package com.example.capstone_apps.ui.authentication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.capstone_apps.databinding.ActivityRegisterBinding
import com.example.capstone_apps.helper.EmailValidation
import com.example.capstone_apps.helper.Key
import com.example.capstone_apps.helper.PasswordValidation
import com.example.capstone_apps.helper.invalidValidation

class RegisterActivity : AppCompatActivity() {
  private lateinit var binding: ActivityRegisterBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityRegisterBinding.inflate(layoutInflater)
    setContentView(binding.root)
    supportActionBar?.hide()

    emailValidation()
    passwordValidation()

    binding.buttonRegister.setOnClickListener {
      val invalid = invalidValidation(
        binding.emailContainer.helperText.toString(),
        binding.passwordContainer.helperText.toString())
      invalidOrNo(invalid)
    }
  }

  private fun invalidOrNo(invalid: Boolean) {
    if(invalid) {
      makeToast("failed register")
    }else{
      makeToast(Key.SUCCESS_REGISTER)
    }
  }

  private fun emailValidation() {
    binding.emailEditText.setOnFocusChangeListener { _, focused ->
      if(!focused) {
        val emailValid = EmailValidation(binding.emailEditText.text.toString())
        binding.emailContainer.helperText = emailValid.validEmail()
      }
    }
  }

  private fun passwordValidation() {
    binding.passwordEditText.setOnFocusChangeListener { _, focused ->
      if(!focused) {
        val passwordValid = PasswordValidation(binding.passwordEditText.text.toString())
        binding.emailContainer.helperText = passwordValid.validationPassword()
      }
    }
  }

  private fun makeToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
  }
}
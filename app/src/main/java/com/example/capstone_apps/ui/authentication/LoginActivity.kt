package com.example.capstone_apps.ui.authentication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.capstone_apps.R
import com.example.capstone_apps.databinding.ActivityLoginBinding
import com.example.capstone_apps.helper.EmailValidation
import com.example.capstone_apps.helper.Key
import com.example.capstone_apps.helper.PasswordValidation
import com.example.capstone_apps.helper.invalidValidation
import com.example.capstone_apps.ui.main.MainActivity

class LoginActivity : AppCompatActivity(), View.OnClickListener {
  private lateinit var binding: ActivityLoginBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityLoginBinding.inflate(layoutInflater)
    setContentView(binding.root)
    supportActionBar?.hide()

    emailValidation()
    passwordValidation()

    binding.buttonDaftar.setOnClickListener(this)
    binding.buttonLogin.setOnClickListener(this)
  }

  override fun onClick(view: View) {
    if(view.id == R.id.buttonDaftar) {
      moveIntentToRegister()
    }
    if(view.id == R.id.buttonLogin) {
      val invalid = invalidValidation(
        binding.emailContainer.helperText.toString(),
        binding.passwordContainer.helperText.toString())
      Log.d("LoginActivity", "<<<< $invalid")
      checkInvalidNullOrNo(invalid)
    }
  }

  private fun checkInvalidNullOrNo(invalid: Boolean) {
    if(invalid) {
      makeToast("failed login")
    }else{
      moveIntentToMain()
      makeToast(Key.SUCCESS_LOGIN)
    }
  }

  private fun moveIntentToMain() {
    startActivity(Intent(this@LoginActivity, MainActivity::class.java))
    finish()
  }

  private fun emailValidation() {
    binding.emailEditText.setOnFocusChangeListener { _, focused ->
      if(!focused) {
        val validEmail = EmailValidation(binding.emailEditText.text.toString())
        binding.emailContainer.helperText = validEmail.validEmail()
      }
    }
  }

  private fun passwordValidation() {
    binding.passwordEditText.setOnFocusChangeListener { _, focused ->
      if(!focused) {
        val validPassword = PasswordValidation(binding.passwordEditText.text.toString())
        binding.passwordContainer.helperText = validPassword.validationPassword()
      }
    }
  }

  private fun moveIntentToRegister() {
    startActivity(Intent(this@LoginActivity, RegisterActivity::class.java))
  }

  private fun makeToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
  }
}
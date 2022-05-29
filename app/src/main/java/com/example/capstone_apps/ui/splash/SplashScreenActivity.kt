package com.example.capstone_apps.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import com.example.capstone_apps.databinding.ActivitySplashScreenBinding
import com.example.capstone_apps.helper.Key
import com.example.capstone_apps.ui.authentication.LoginActivity

class SplashScreenActivity : AppCompatActivity() {
  private lateinit var binding: ActivitySplashScreenBinding
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivitySplashScreenBinding.inflate(layoutInflater)
    setContentView(binding.root)
    supportActionBar?.hide()
    handlerSplash()

    binding.spinKit.visibility = View.VISIBLE
  }

  private fun handlerSplash(): Boolean {
    return Handler(Looper.getMainLooper()).postDelayed({
      startActivity(Intent(this@SplashScreenActivity, LoginActivity::class.java))
      finish()
    }, Key.TIME)
  }
}
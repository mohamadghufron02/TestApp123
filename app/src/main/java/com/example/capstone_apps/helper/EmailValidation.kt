package com.example.capstone_apps.helper

import android.util.Patterns

class EmailValidation (private val emailText: String) {

  fun validEmail(): String? {
    if(!Patterns.EMAIL_ADDRESS.matcher(emailText).matches()) {
      return Key.INVALID_EMAIL
    }
    return null
  }
}
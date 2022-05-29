package com.example.capstone_apps.helper

import android.util.Log


fun invalidValidation(emailHelper: String, passwordHelper: String): Boolean{
  if(emailHelper != null) {
    Log.d("LoginActivity", "data email $emailHelper")
   return true
  }

  if(passwordHelper != null) {
    Log.d("LoginActivity", "data password $passwordHelper")
   return true
  }

  return false
}
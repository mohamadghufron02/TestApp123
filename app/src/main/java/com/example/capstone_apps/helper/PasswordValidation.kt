package com.example.capstone_apps.helper

class PasswordValidation (private val passwordText: String) {

  fun validationPassword(): String? {
    if(passwordText.length < 8) {
      return Key.MINiMUN_CHAR
    }
    if(!passwordText.matches(Key.UPPERCASE_REGEX.toRegex())) {
      return Key.UPPERCASE_CHAR
    }
    if(!passwordText.matches(Key.LOWERCASE_REGEX.toRegex())) {
      return Key.LOWERCASE_CHAR
    }
    if(!passwordText.matches(Key.SPECIAL_REGEX.toRegex())) {
      return Key.SPECIAL_CHAR
    }

    return null
  }
}
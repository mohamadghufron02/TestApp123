package com.example.capstone_apps.helper

class Key {
  companion object {
    const val TIME = 1500L
    const val INVALID_EMAIL = "Invalid Email address"
    const val MINiMUN_CHAR = "Minimum 8 Character Password"
    const val UPPERCASE_CHAR = "Must Contain 1 Upper-case Character"
    const val LOWERCASE_CHAR =  "Must Contain 1 Lower-case Character"
    const val SPECIAL_CHAR = "Must Contain 1 Special Character (@#\$%^&+=)"

    // regex
    const val UPPERCASE_REGEX = ".*[A-Z].*"
    const val LOWERCASE_REGEX = ".*[a-z].*"
    const val SPECIAL_REGEX = ".*[@#\$%^&+=].*"

    //login
    const val SUCCESS_LOGIN = "success login"

    //register
    const val SUCCESS_REGISTER = "success register"
  }
}
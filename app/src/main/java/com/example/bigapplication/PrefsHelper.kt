package com.example.bigapplication

import android.content.Context
import android.content.SharedPreferences

object PrefsHelper {

    lateinit var preferences: SharedPreferences

    private const val PREFS_NAME = "params"
    private const val USER_ID = "USERID"
    private const val IS_REMEMBER = "isSaveChecked"

    // init from App
    fun init(context: Context) {
        preferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    }


}
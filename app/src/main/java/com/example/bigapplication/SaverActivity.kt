package com.example.bigapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle


import android.widget.TextView

import android.content.SharedPreferences
import android.view.View

import android.widget.EditText


class SaverActivity : AppCompatActivity() {
    var settings: SharedPreferences? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_saver)
        settings = getSharedPreferences(SaverActivity.Companion.PREFS_FILE, MODE_PRIVATE)
    }

    fun saveName(view: View?) {
        // получаем введенное имя
        val nameBox = findViewById<View>(R.id.nameBox) as EditText
        val name = nameBox.text.toString()
        // сохраняем его в настройках
        val prefEditor = settings!!.edit()
        prefEditor.putString(SaverActivity.Companion.PREF_NAME, name)
        prefEditor.apply()
    }

    fun getName(view: View?) {
        // получаем сохраненное имя
        val nameView = findViewById<View>(R.id.nameView) as TextView
        val name = settings!!.getString(SaverActivity.Companion.PREF_NAME, "не определено")
        nameView.text = name
    }

    companion object {
        private const val PREFS_FILE = "Account"
        private const val PREF_NAME = "Name"
    }
}
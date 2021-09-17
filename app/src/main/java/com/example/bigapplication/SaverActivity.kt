package com.example.bigapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.SharedPreferences
import android.view.View
import com.example.bigapplication.databinding.ActivitySaverBinding


class SaverActivity : AppCompatActivity() {
    private var settings: SharedPreferences? = null
    private lateinit var binding: ActivitySaverBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySaverBinding.inflate(layoutInflater)
        setContentView(binding.root)
        settings = getSharedPreferences(Preferences.PREFS_FILE, MODE_PRIVATE)
    }

    fun saveName(view: View?) {
        // получаем введенное имя и сохраняем его в настройках
        val prefEditor = settings?.edit()
        prefEditor?.putString(Preferences.PREF_NAME, binding.nameBox.text.toString())
        prefEditor?.commit()
    }

    fun getName(view: View?) {
        // получаем сохраненное имя
        binding.nameView.text = settings?.getString(Preferences.PREF_NAME, "empty")
    }

    fun eraseName(view: View) {
        // стираем введенное имя и сохраняем null в настройках
        settings?.edit()?.clear()?.commit()
    }
}
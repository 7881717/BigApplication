package com.example.bigapplication

import android.app.Application

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        PrefsHelper.init(applicationContext)
    }
}
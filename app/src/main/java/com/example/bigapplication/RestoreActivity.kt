package com.example.bigapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class RestoreActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restore)

// nothing here

    }

    override fun onDestroy() {
        println(object : Any(){}.javaClass.enclosingMethod?.name)
        super.onDestroy()
    }
}
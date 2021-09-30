package com.bigapplication.ui.restore

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bigapplication.R

class RestoreActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restore)
    }

    override fun onDestroy() {
        println(object : Any() {}.javaClass.enclosingMethod?.name)
        super.onDestroy()
    }
}
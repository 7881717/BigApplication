package com.bigapplication.ui.restore

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bigapplication.R

class RestoreActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restore)
    }

    override fun onDestroy() {
        println("CALLED CALLBACK \"" + object : Any() {}.javaClass.enclosingMethod?.name + "\"")
        val toast = Toast.makeText(applicationContext, "RestoreActivity CLOSED", Toast.LENGTH_SHORT)
        toast.show()
        super.onDestroy()
    }
}
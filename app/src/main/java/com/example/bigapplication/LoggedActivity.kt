package com.example.bigapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView


import android.view.View
import java.util.*


class LoggedActivity : AppCompatActivity() {
    var tvView: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logged)


        tvView = findViewById<View>(R.id.tv_log1) as TextView

        val intent = intent

        // data from previous activity
        val userEmail = intent.getStringExtra("Useremail")
        val userPassword = intent.getStringExtra("Userpassword")

        // first name parser
        val preName = userEmail?.substringBefore("@")
        val first = preName?.substringBefore('.')
            ?.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault())
            else it.toString() }

        // second name parser
        val preLast = preName?.substringAfter('.')
        val last = preLast?.substringBefore('.')
            ?.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault())
            else it.toString() }

        // show parsed names
        val toShow = "$first $last"
        tvView?.text = toShow

    }
}
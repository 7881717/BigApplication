package com.example.bigapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bigapplication.databinding.ActivityLoggedBinding
import java.util.*


class LoggedActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoggedBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoggedBinding.inflate(layoutInflater)
        setContentView(binding.root)


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
        binding.tvUserName.text = toShow
    }
}
package com.bigapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bigapplication.databinding.ActivityLoggedBinding
import com.bumptech.glide.Glide
import java.util.*


class LoggedActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoggedBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoggedBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // avatar rounding
        Glide.with(binding.imageViewProfileImage)
            .load(R.drawable.vladface)
            .circleCrop()
            .into(binding.imageViewProfileImage)

        val intent = intent

        // data from previous activity
        val userEmail = intent.getStringExtra("UserEmail")
        val userPassword = intent.getStringExtra("UserPassword")

        // first name parser
        val preName = userEmail?.substringBefore("@")
        val first = preName?.substringBefore('.')
            ?.replaceFirstChar {
                if (it.isLowerCase()) it.titlecase(Locale.getDefault())
                else it.toString()
            }

        // second name parser
        val preLast = preName?.substringAfter('.')
        val last = preLast?.substringBefore('.')
            ?.replaceFirstChar {
                if (it.isLowerCase()) it.titlecase(Locale.getDefault())
                else it.toString()
            }

        // show parsed names
        val toShow = "$first $last"
        binding.textViewUserName.text = toShow

        binding.textViewLogOut.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            getSharedPreferences(Preferences.PREFS_FILE, MODE_PRIVATE)?.edit()?.clear()?.commit()
            startActivity(intent)
            finish()
        }

        binding.buttonViewMyContacts.setOnClickListener {
            val intent = Intent(this, ContactsActivity::class.java)
            // Contacts Activity start
            startActivity(intent)
            finish()
        }
    }
}
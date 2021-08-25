package com.example.bigapplication

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bigapplication.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    @SuppressLint("CutPasteId")
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Login button
        binding.buttonLogin.setOnClickListener {

            if (emailChecker() && passwordChecker()) {
                val intent = Intent(this, LoggedActivity::class.java)

                // data for next activity
                intent.putExtra("Useremail", binding.etEmail.text.toString())
                intent.putExtra("Userpassword", binding.etPassword.text.toString())

                // Logged Activity start
                startActivity(intent)
                finish()
            }
        }

        // tap forgot password
        binding.tvForgotPassword.setOnClickListener {

            // Restore Activity start
            val intent = Intent(this, RestoreActivity::class.java)
            startActivity(intent)
            finish()
        }

        // tap sign up
        binding.tvSignUp.setOnClickListener {

            // Auth Activity start
            val intent = Intent(this, AuthActivity::class.java)
            startActivity(intent)
            finish()
        }

    }

    private fun emailChecker(): Boolean {
        // validation flag
        var emailCorrect = false

        val email = binding.etEmail.text.trim { it <= ' ' }
        // email regex
        val emailRegex = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"

        // email check
        if (emailRegex.toRegex().matches(email)) {
            emailCorrect = true
        } else {
            // wrong email message
            binding.etEmail.error = getString(R.string.invalid_email)
        }
        return emailCorrect
    }

    private fun passwordChecker(): Boolean {
        // validation flag
        var passwordCorrect = false

        val password = binding.etPassword.text

        // password check
        if (password.length > 7) {
            passwordCorrect = true
        } else {
            // invalid password message
            binding.etPassword.error = getString(R.string.invalid_password)
        }
        return passwordCorrect
    }

}
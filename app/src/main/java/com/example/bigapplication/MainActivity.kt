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

            // cheat code for fast forward to next activity
            val cheatCode = true
            if (cheatCode || (emailChecker() && passwordChecker())) {
                val intent = Intent(this, LoggedActivity::class.java)

                // data for next activity
                if (cheatCode) intent.putExtra("UserEmail", "ladislaw.pszczelarz@okno.co")
                else intent.putExtra("UserEmail", binding.editTextEmail.text.toString())
                intent.putExtra("UserPassword", binding.editTextPassword.text.toString())

                // Logged Activity start
                startActivity(intent)
                finish()
            }
        }

        // tap forgot password
        binding.textViewForgotPassword.setOnClickListener {

            // Restore Activity start
            val intent = Intent(this, RestoreActivity::class.java)
            startActivity(intent)
            finish()
        }

        // tap sign up
        binding.textViewSignUp.setOnClickListener {

            // Auth Activity start
            val intent = Intent(this, AuthActivity::class.java)
            startActivity(intent)
            finish()
        }

    }

    private fun emailChecker(): Boolean {
        // validation flag
        var emailCorrect = false

        val email = binding.editTextEmail.text?.trim { it <= ' ' }
        // email regex
        val emailRegex = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"

        // email check
        if (emailRegex.toRegex().matches(email.toString())) {
            emailCorrect = true
        } else {
            // wrong email message
            binding.editTextEmail.error = getString(R.string.invalid_email)
        }
        return emailCorrect
    }

    private fun passwordChecker(): Boolean {
        // validation flag
        var passwordCorrect = false

        val password = binding.editTextPassword.text

        // password check
        if (password?.length!! > 7) {
            passwordCorrect = true
        } else {
            // invalid password message
            binding.editTextPassword.error = getString(R.string.invalid_password)
        }
        return passwordCorrect
    }

}
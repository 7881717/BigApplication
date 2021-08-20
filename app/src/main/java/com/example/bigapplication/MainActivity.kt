package com.example.bigapplication

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView


import android.widget.EditText


class MainActivity : AppCompatActivity() {
    @SuppressLint("CutPasteId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Login button
        val buttonLogin = findViewById<View>(R.id.btnLogin) as Button
        buttonLogin.setOnClickListener {

            // data for next activity
            val nameText = findViewById<EditText>(R.id.etEmail)
            val pwdText = findViewById<EditText>(R.id.etPassword)


            val userEmail = nameText.text.toString()
            val userPassword = pwdText.text.toString()


            val intent = Intent(this, LoggedActivity::class.java)

            intent.putExtra("Useremail", userEmail)
            intent.putExtra("Userpassword", userPassword)

            // Logged Activity start
            if (emailChecker() && passwordChecker()) startActivity(intent)
        }

        val forgotPassword = findViewById<View>(R.id.tvForgotPassword) as TextView
        forgotPassword.setOnClickListener {

            // Restore Activity start
            val intent = Intent(this, RestoreActivity::class.java)
            startActivity(intent)
        }

        val signUp = findViewById<View>(R.id.tvSignUp) as TextView
        signUp.setOnClickListener {

            // Auth Activity start
            val intent = Intent(this, AuthActivity::class.java)
            startActivity(intent)
        }

    }

    private fun emailChecker(): Boolean {
        // validation flag
        var emailCorrect = false

        val emailValidate = findViewById<View>(R.id.etEmail) as EditText
        val email = emailValidate.text.toString().trim { it <= ' ' }
        // email regex
        val emailRegex = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"

        // email check
        if (emailRegex.toRegex().matches(email)) {
            emailCorrect = true
        } else {
            // wrong email message
            emailValidate.error = getString(R.string.invalid_email)
        }
        return emailCorrect
    }

    private fun passwordChecker(): Boolean {
        // validation flag
        var passwordCorrect = false

        val passwordValidate = findViewById<View>(R.id.etPassword) as EditText
        val password = passwordValidate.text.toString()

        // password check
        if (password.length > 7) {
            passwordCorrect = true
        } else {
            // invalid password message
            passwordValidate.error = getString(R.string.invalid_password)
        }
        return passwordCorrect
    }

}
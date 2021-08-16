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
        val vButton0 = findViewById<View>(R.id.button0) as Button
        vButton0.setOnClickListener {

            // validation flags
            var emailCorrect = false
            var passwordCorrect = false

            val pair = mailAndPasswordValidator(emailCorrect, passwordCorrect)
            emailCorrect = pair.first
            passwordCorrect = pair.second

            // data for next activity
            val nameText = findViewById<EditText>(R.id.tv_email_edit)
            val pwdText = findViewById<EditText>(R.id.tv_password_edit)


            val userName = nameText.text.toString()
            val userPassword = pwdText.text.toString()


            val intent = Intent(this, LoggedActivity::class.java)

            intent.putExtra("Username", userName)
            intent.putExtra("Userpassword", userPassword)

            // Logged Activity start
            if (emailCorrect && passwordCorrect) startActivity(intent)
        }

        val vlink0 = findViewById<View>(R.id.tv_link_forgot_password) as TextView
        vlink0.setOnClickListener {

            // Restore Activity start
            val intent = Intent(this, RestoreActivity::class.java)
            startActivity(intent)
        }

        val vlink1 = findViewById<View>(R.id.tv_link_sign_up) as TextView
        vlink1.setOnClickListener {

            // Auth Activity start
            val intent = Intent(this, AuthActivity::class.java)
            startActivity(intent)
        }

    }

    private fun mailAndPasswordValidator(
        emailCorrect: Boolean,
        passwordCorrect: Boolean
    ): Pair<Boolean, Boolean> {
        var emailCorrect1 = emailCorrect
        var passwordCorrect1 = passwordCorrect
        val emailValidate = findViewById<View>(R.id.tv_email_edit) as EditText

        val textView = findViewById<View>(R.id.tv_email_verify) as TextView

        val email = emailValidate.text.toString().trim { it <= ' ' }

        // email regex
        val emailRegex = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"

        // validator function
        fun isEmailValid(email: String): Boolean {
            return emailRegex.toRegex().matches(email)
        }

        // email check
        if (isEmailValid(email)) {
            emailCorrect1 = true
            textView.text = " "
        } else {
            // wrong email message
            textView.text = getString(R.string.invalid_email)
        }

        val passwordValidate = findViewById<View>(R.id.tv_password_edit) as EditText

        val textView1 = findViewById<View>(R.id.tv_password_verify) as TextView

        val password = passwordValidate.text.toString()

        // password check
        if (password.length > 7) {
            textView1.text = " "
            passwordCorrect1 = true
        } else {
            // invalid password message
            textView1.text = getString(R.string.invalid_password)
        }
        return Pair(emailCorrect1, passwordCorrect1)
    }

}
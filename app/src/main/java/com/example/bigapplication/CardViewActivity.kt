package com.example.bigapplication

import android.widget.TextView

import android.os.Bundle

import android.app.Activity
import android.view.View
import android.widget.ImageView


class CardViewActivity : Activity() {
    var personName: TextView? = null
    var personAge: TextView? = null
    var personPhoto: ImageView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.cardview_activity)
        personName = findViewById<View>(R.id.person_name) as TextView
        personAge = findViewById<View>(R.id.person_age) as TextView
        personPhoto = findViewById<View>(R.id.person_photo) as ImageView
        personName!!.text = "Emma Wilson"
        personAge!!.text = "23 years old"
        personPhoto!!.setImageResource(R.drawable.emma)
    }
}
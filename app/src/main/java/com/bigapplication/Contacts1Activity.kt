package com.bigapplication

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import android.view.View

import android.app.Activity


class Contacts1Activity : Activity() {
    private var persons: MutableList<Person>? = null
    private var rv: RecyclerView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contacts1)
        rv = findViewById<View>(R.id.rv) as RecyclerView
        val llm = LinearLayoutManager(this)
        rv?.layoutManager = llm
        initializeData()
        initializeAdapter()
    }

    private fun initializeData() {
        persons = ArrayList()
        repeat(7) {
            persons?.add(Person("Emma Wilson", "23 years old", R.drawable.emma))
            persons?.add(Person("Ann Lace", "25 years old", R.drawable.lavery))
            persons?.add(Person("Lillie Watts", "35 years old", R.drawable.lillie))
            persons?.add(Person("Columbia", "202 years old", R.drawable.columbia))
        }
    }

    private fun initializeAdapter() {
        val adapter = Adapter1(persons!!)
        rv?.adapter = adapter
    }
}
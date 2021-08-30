package com.example.bigapplication


import androidx.recyclerview.widget.LinearLayoutManager

import androidx.recyclerview.widget.RecyclerView

import android.os.Bundle

import android.app.Activity
import android.view.View


class RecyclerViewActivity : Activity() {
    private var persons: MutableList<Person>? = null
    private var rv: RecyclerView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recyclerview_activity)
        rv = findViewById<View>(R.id.rv) as RecyclerView
        val llm = LinearLayoutManager(this)
        rv!!.layoutManager = llm
        rv!!.setHasFixedSize(true)
        initializeData()
        initializeAdapter()
    }

    private fun initializeData() {
        persons = ArrayList()
        persons!!.add(Person("Emma Wilson", "23 years old", R.drawable.emma))
        persons!!.add(Person("Lavery Maiss", "25 years old", R.drawable.lavery))
        persons!!.add(Person("Lillie Watts", "35 years old", R.drawable.lillie))
    }

    private fun initializeAdapter() {
        val adapter = RVAdapter(persons!!)
        rv!!.adapter = adapter
    }
}
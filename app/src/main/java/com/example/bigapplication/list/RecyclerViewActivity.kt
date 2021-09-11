package com.example.bigapplication.list


import androidx.recyclerview.widget.LinearLayoutManager

import androidx.recyclerview.widget.RecyclerView

import android.os.Bundle

import android.app.Activity
import com.example.bigapplication.Person
import com.example.bigapplication.R
import com.example.bigapplication.databinding.ActivityRecyclerviewBinding
import com.example.bigapplication.newList.ContactsAdapter


class RecyclerViewActivity : Activity() {
    private var persons: MutableList<Person>? = null
    private lateinit var rv: RecyclerView
    private lateinit var binding: ActivityRecyclerviewBinding
    private lateinit var adapter: ContactsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerviewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        rv = binding.rv
        rv.layoutManager = LinearLayoutManager(this)
        rv.setHasFixedSize(true)

        initializeData()
        initializeAdapter()

    }

    private fun initializeData() {
        persons = ArrayList()
        repeat(22){
            persons?.let { list ->
                list.add(Person("Emma Wilson", "23 years old", R.drawable.emma))
                list.add(Person("Lavery Maiss", "25 years old", R.drawable.lavery))
                list.add(Person("Lillie Watts", "35 years old", R.drawable.lillie))
            }
        }

    }

    private fun initializeAdapter() {
        adapter = ContactsAdapter()
        rv.adapter = adapter
        adapter.submitList(persons)
    }
}
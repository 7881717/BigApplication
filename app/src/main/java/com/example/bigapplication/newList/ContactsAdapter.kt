package com.example.bigapplication.newList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.bigapplication.Person
import com.example.bigapplication.PrefsHelper
import com.example.bigapplication.databinding.ItemBinding

class ContactsAdapter : ListAdapter<Person, ContactHolder>(DiffCallBack) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactHolder {

        return ContactHolder(
            ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ContactHolder, position: Int) {

        val person = getItem(position)
        holder.bind(person)
    }

}
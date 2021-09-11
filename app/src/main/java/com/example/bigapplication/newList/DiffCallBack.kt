package com.example.bigapplication.newList

import androidx.recyclerview.widget.DiffUtil
import com.example.bigapplication.Person

object DiffCallBack : DiffUtil.ItemCallback<Person>() {
        override fun areItemsTheSame(oldItem: Person, newItem: Person): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Person, newItem: Person): Boolean {
            return oldItem == newItem
        }
    }
package com.example.bigapplication.newList


import androidx.recyclerview.widget.RecyclerView
import com.example.bigapplication.Person
import com.example.bigapplication.PrefsHelper
import com.example.bigapplication.databinding.ItemBinding

class ContactHolder(
    private val binding: ItemBinding,
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(person: Person) {
        binding.apply {
            personAge.text = person.age
            personName.text = PrefsHelper.preferences.getString("KEY", "DAS")
            personPhoto.setImageResource(person.photoId)
        }
    }

}
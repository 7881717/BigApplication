package com.bigapplication.ui.contacts.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bigapplication.databinding.ItemBinding
import com.bigapplication.model.User
import com.bigapplication.ui.contacts.adapter.listeners.IContactClickListener
import com.bigapplication.ui.contacts.adapter.viewholder.PersonViewHolder

class ContactsAdapter internal constructor(
    private val users: MutableList<User>,
    private val onIContactClickListener: IContactClickListener
) :
    RecyclerView.Adapter<PersonViewHolder>() {


    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): PersonViewHolder {
        val binding = ItemBinding.inflate(
            LayoutInflater.from(viewGroup.context), viewGroup, false
        )
//        val v: View =
//            LayoutInflater.from(viewGroup.context).inflate(R.layout.item, viewGroup, false)
        return PersonViewHolder(binding, onIContactClickListener)
    }

    override fun onBindViewHolder(personViewHolder: PersonViewHolder, position: Int) {
        personViewHolder.bindTo(users[position], position)
    }

    override fun getItemCount(): Int {
        return users.size
    }
}
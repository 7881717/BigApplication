package com.bigapplication.ui.contacts.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bigapplication.databinding.ItemBinding
import com.bigapplication.model.Contact
import com.bigapplication.ui.contacts.adapter.listeners.IContactClickListener
import com.bigapplication.ui.contacts.adapter.viewholder.PersonViewHolder
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.DiffUtil.DiffResult
import com.bigapplication.utils.tracing
import java.lang.Exception


class ContactsAdapter internal constructor(
    private val contacts: MutableList<Contact>,
    private val onIContactClickListener: IContactClickListener
) :
    RecyclerView.Adapter<PersonViewHolder>() {


    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): PersonViewHolder {
        val binding = ItemBinding.inflate(
            LayoutInflater.from(viewGroup.context), viewGroup, false
        )
//        val v: View =
//            LayoutInflater.from(viewGroup.context).inflate(R.layout.item, viewGroup, false)
        return PersonViewHolder(binding, onIContactClickListener)
    }

    override fun onBindViewHolder(personViewHolder: PersonViewHolder, position: Int) {

        tracing("${Exception().stackTrace[0]} position = $position", ">>>>")

        personViewHolder.bindTo(contacts[position])

    }

    override fun getItemCount(): Int {
        return contacts.size
    }

    fun updateItems(newDataset: MutableList<Contact>) {
        val diffResult: DiffResult =
            DiffUtil.calculateDiff(ContactDiffUtilCallback(contacts, newDataset))
        diffResult.dispatchUpdatesTo(this)
        contacts.clear()
        contacts.addAll(newDataset)
    }
}
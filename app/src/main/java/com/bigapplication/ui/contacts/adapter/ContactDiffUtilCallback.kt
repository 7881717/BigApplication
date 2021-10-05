package com.bigapplication.ui.contacts.adapter

import androidx.recyclerview.widget.DiffUtil
import com.bigapplication.model.Contact


class ContactDiffUtilCallback(
    private val oldList: List<Contact>,
    private val newList: List<Contact>
) :
    DiffUtil.Callback() {

    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    //fixme add id
    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldContact: Contact = oldList[oldItemPosition]
        val newContact: Contact = newList[newItemPosition]
        return oldContact == newContact
//        return oldUser.id == newUser.id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldContact: Contact = oldList[oldItemPosition]
        val newContact: Contact = newList[newItemPosition]
        return oldContact == newContact
    }

}
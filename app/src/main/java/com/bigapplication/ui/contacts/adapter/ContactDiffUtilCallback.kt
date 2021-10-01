package com.bigapplication.ui.contacts.adapter

import androidx.recyclerview.widget.DiffUtil
import com.bigapplication.model.User


class ContactDiffUtilCallback(
    private val oldList: List<User>,
    private val newList: List<User>
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
        val oldUser: User = oldList[oldItemPosition]
        val newUser: User = newList[newItemPosition]
        return oldUser == newUser
//        return oldUser.id == newUser.id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldUser: User = oldList[oldItemPosition]
        val newUser: User = newList[newItemPosition]
        return oldUser == newUser
    }

}
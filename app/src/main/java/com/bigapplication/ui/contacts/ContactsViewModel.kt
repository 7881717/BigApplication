package com.bigapplication.ui.contacts

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bigapplication.R
import com.bigapplication.model.Contact
import com.bigapplication.utils.Events

class ContactsViewModel : ViewModel() {

    val contactsListLiveData = MutableLiveData<MutableList<Contact>>(ArrayList())
    val eventsLiveData = MutableLiveData<Events>()

    init {
        //        usersListLiveData.value = mutableListOf()
        eventsLiveData.value = Events.LOADING
        if (contactsListLiveData.value?.isNullOrEmpty() == true) {
            contactsListLiveData.value?.apply {
                add(Contact(0,"Emma", "Wilson", "nice girl", R.drawable.emma))
                add(Contact(1,"Ann", "Lace", "ordinary girl", R.drawable.lavery))
                add(Contact(2,"Lillie", "Watts", "pretty woman", R.drawable.lillie))
                add(
                    Contact(
                        3,
                        "Columbia",
                        ", the country of",
                        "best country",
                        R.drawable.columbia
                    )
                )
            }
        }

        if(contactsListLiveData.value?.isNullOrEmpty() == true) {
            eventsLiveData.value = Events.LOADING_ERROR
        } else {
            eventsLiveData.value = Events.OK
        }
    }

    fun addItem(contact: Contact) {
        contactsListLiveData.value?.add(contact)
        contactsListLiveData.value = contactsListLiveData.value
    }

    fun removeItemAt(position: Int) {
        // trash can clicked.
        contactsListLiveData.value?.removeAt(position)
        contactsListLiveData.value = contactsListLiveData.value
    }


//    fun setList(list: MutableList<User>) {
//        contactsListLiveData.value = list
//    }
}
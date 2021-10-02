package com.bigapplication.ui.contacts

import android.content.Context
import androidx.appcompat.widget.AppCompatTextView
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bigapplication.R
import com.bigapplication.model.User

class ContactsViewModel : ViewModel() {

    val contactsListLiveData = MutableLiveData<MutableList<User>>(ArrayList())
    val eventsLiveData = MutableLiveData<Events>()

    //fixme move to utils
    enum class Events {
        OK, INTERNET_ERROR, LOADING_ERROR, LOADING
    }

    fun initializeData() {
        //fixme bug when screen rotates and new contacts are added
//        usersListLiveData.value = mutableListOf()
        eventsLiveData.value = Events.LOADING
        if (contactsListLiveData.value?.isNullOrEmpty() == true) {
            contactsListLiveData.value?.apply {
                add(User("Emma", "Wilson", "nice girl", R.drawable.emma))
                add(User("Ann", "Lace", "ordinary girl", R.drawable.lavery))
                add(User("Lillie", "Watts", "pretty woman", R.drawable.lillie))
                add(
                    User(
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

    fun addItem(user: User) {
        contactsListLiveData.value?.add(user)
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
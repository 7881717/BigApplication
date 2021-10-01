package com.bigapplication.ui.contacts

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bigapplication.R
import com.bigapplication.databinding.ActivityContactsBinding
import com.bigapplication.model.User
import com.bigapplication.ui.contacts.adapter.ContactsAdapter
import com.bigapplication.ui.contacts.adapter.listeners.IContactClickListener

class ContactsActivity : Activity(), IContactClickListener {
    private var users: MutableList<User>? = null
    private lateinit var adapter: ContactsAdapter
    private lateinit var binding: ActivityContactsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContactsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initializeData()
        initRecycler()


//        val llm = LinearLayoutManager(this)
//        rv?.layoutManager = llm

//        initializeAdapter()

        //Добавляем слушателя нажатий по ссылке addLink:
        setListeners()

    }

    private fun setListeners() {

        //Инициализируем элементы:
        binding.textViewAddContacts.setOnClickListener { //Получаем вид с файла prompt.xml, который применим для диалогового окна:
            val li = LayoutInflater.from(applicationContext)
            val promptsView = li.inflate(R.layout.prompt, null)

            //Создаем AlertDialog
            val mDialogBuilder = AlertDialog.Builder(applicationContext)

            //Настраиваем prompt.xml для нашего AlertDialog:
            mDialogBuilder.setView(promptsView)

            //Настраиваем отображение поля для ввода текста в открытом диалоге:
            val newName = promptsView.findViewById<View>(R.id.editTextName) as EditText
            val newSurname = promptsView.findViewById<View>(R.id.editTextSurname) as EditText
            val newCareer = promptsView.findViewById<View>(R.id.editTextCareer) as EditText

            //Настраиваем сообщение в диалоговом окне:
            mDialogBuilder
                //                .setTitle("Add contact")
                .setCancelable(true)
                .setPositiveButton(
                    "OK"
                ) { dialog, id -> //Вводим текст и отображаем в строке ввода на основном экране:
                    users?.add(
                        User(
                            newName.text.toString(),
                            newSurname.text.toString(),
                            newCareer.text.toString(),
                            R.drawable.brazilia
                        )
                    )
                    //                    initializeAdapter()
                    // перерисовываем ресайклер
                    adapter.updateItems(users?: return@setPositiveButton)
                }
                .setNegativeButton(
                    "Отмена"
                ) { dialog, id -> dialog.cancel() }

            //Создаем AlertDialog:
            val alertDialog = mDialogBuilder.create()

            //и отображаем его:
            alertDialog.show()

        }

    }

    private fun initRecycler() {
        binding.recyclerViewContacts.layoutManager = LinearLayoutManager(
            applicationContext,
            LinearLayoutManager.VERTICAL,
            false
        )
        adapter = ContactsAdapter(users ?: ArrayList(), onIContactClickListener = this)
        binding.recyclerViewContacts.adapter = adapter
    }

    override fun removeContact(position: Int) {
        // trash can clicked.
        users?.removeAt(position)
        adapter.updateItems(users ?: return)
    }


    private fun initializeData() {
        users = ArrayList()

        users?.add(User("Emma", "Wilson", "nice girl", R.drawable.emma))
        users?.add(User("Ann", "Lace", "ordinary girl", R.drawable.lavery))
        users?.add(User("Lillie", "Watts", "pretty woman", R.drawable.lillie))
        users?.add(
            User(
                "Columbia",
                ", the country of",
                "best country",
                R.drawable.columbia
            )
        )

    }
}
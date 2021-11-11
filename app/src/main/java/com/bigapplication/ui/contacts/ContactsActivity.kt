package com.bigapplication.ui.contacts

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bigapplication.R
import com.bigapplication.databinding.ActivityContactsBinding
import com.bigapplication.model.Contact
import com.bigapplication.ui.contacts.adapter.ContactsAdapter
import com.bigapplication.ui.contacts.adapter.listeners.IContactClickListener
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import com.bigapplication.utils.Events
import com.bigapplication.utils.tracing
import java.lang.Exception


//todo I replaced activity to AppCompatActivity
class ContactsActivity : AppCompatActivity(), IContactClickListener {
    private lateinit var contactsAdapter: ContactsAdapter
    private lateinit var binding: ActivityContactsBinding
    private lateinit var viewModel: ContactsViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContactsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(ContactsViewModel::class.java)

        initRecycler()
        setObservers()
        setListeners()


//        val llm = LinearLayoutManager(this)
//        rv?.layoutManager = llm

//        initializeAdapter()

        //Добавляем слушателя нажатий по ссылке addLink:
    }

    private fun setObservers() {
        viewModel.contactsListLiveData.observe(this) { list ->
            // перерисовываем ресайклер
            contactsAdapter.updateItems(list)
        }

        viewModel.eventsLiveData.observe(this) {
            when (it) {
                Events.OK -> {
                    val toast = Toast.makeText(applicationContext, "OK", LENGTH_SHORT)
                    toast.show()
                }
                Events.LOADING_ERROR -> {
                    val toast = Toast.makeText(applicationContext, "LOADING ERROR", LENGTH_SHORT)
                    toast.show()
                }
                Events.LOADING -> {
                    //todo show ProgressBar

                    tracing("${Exception().stackTrace[0]} Progress bar")

                }
                Events.INTERNET_ERROR -> {
                    val toast = Toast.makeText(applicationContext, "INTERNET ERROR", LENGTH_SHORT)
                    toast.show()
                }
                else -> {}
            }
        }
    }

    private fun setListeners() {

        //Инициализируем элементы:
        binding.textViewAddContacts.setOnClickListener {
            showDialogMessage()
        }
    }

    private fun showDialogMessage() {
        //Получаем вид с файла prompt.xml, который применим для диалогового окна:
        val li = LayoutInflater.from(this)
        val promptsView = li.inflate(R.layout.prompt, null)

        //Создаем AlertDialog
        val mDialogBuilder = AlertDialog.Builder(this)

        //Настраиваем prompt.xml для нашего AlertDialog:
        mDialogBuilder.setView(promptsView)

        //Настраиваем отображение поля для ввода текста в открытом диалоге:
        //fixme use view binding

        val newID = biggestIdentity()

        tracing("${Exception().stackTrace[0]} new ID = $newID")

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
                viewModel.addItem(
                    Contact(
                        newID,
                        newName.text.toString(),
                        newSurname.text.toString(),
                        newCareer.text.toString(),
                        R.drawable.brazilia
                    )
                )
            }
            .setNegativeButton(
                "CANCEL"
            ) { dialog, id -> dialog.cancel() }

        //Создаем AlertDialog:
        val alertDialog = mDialogBuilder.create()

        //и отображаем его:
        alertDialog.show()
    }

    private fun biggestIdentity(): Int {
        var newID = 0
        val new = viewModel.contactsListLiveData.value?.maxOf { it.iD }?.plus(1)
        if (new != null) {
            newID = new
        }
        return newID
    }

    private fun initRecycler() {
        binding.recyclerViewContacts.layoutManager = LinearLayoutManager(
            this@ContactsActivity,
            LinearLayoutManager.VERTICAL,
            false
        )
        contactsAdapter =
            ContactsAdapter(
                viewModel.contactsListLiveData.value?.toMutableList() ?: ArrayList(),
                onIContactClickListener = this@ContactsActivity
            )
        binding.recyclerViewContacts.adapter = contactsAdapter

    }

    override fun removeContact(position: Int) {

        tracing("${Exception().stackTrace[0]} removed = " + viewModel.contactsListLiveData.value!![position].iD)

        viewModel.removeItemAt(position)
    }
}


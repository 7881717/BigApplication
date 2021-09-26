package com.bigapplication

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import android.view.View

import android.app.Activity

import android.app.AlertDialog
import android.content.Context
import android.widget.TextView
import android.view.LayoutInflater
import android.widget.EditText

class Contacts1Activity : Activity() {
    private var persons: MutableList<Person>? = null
    private var rv: RecyclerView? = null

    val context: Context = this
    private var addLink: TextView? = null
    private var finalText: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contacts1)
        rv = findViewById<View>(R.id.rv) as RecyclerView
        val llm = LinearLayoutManager(this)
        rv?.layoutManager = llm

        initializeData()
        initializeAdapter()
        //Инициализируем элементы:
        addLink = findViewById<View>(R.id.textViewAddContacts) as TextView
        finalText = findViewById<View>(R.id.final_text) as TextView

        //Добавляем слушателя нажатий по ссылке addLink:
        addLink?.setOnClickListener { //Получаем вид с файла prompt.xml, который применим для диалогового окна:
            val li = LayoutInflater.from(context)
            val promptsView = li.inflate(R.layout.prompt, null)

            //Создаем AlertDialog
            val mDialogBuilder = AlertDialog.Builder(context)

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
                    finalText?.text = newName.text
                    persons?.add(
                        Person(newName.text.toString(),
                            newSurname.text.toString(),
                            newCareer.text.toString(),
                            R.drawable.brazilia)
                    )
                    initializeAdapter()
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

    private fun initializeData() {
        persons = ArrayList()
        repeat(2) {
            persons?.add(Person("Emma", "Wilson", "nice girl", R.drawable.emma))
            persons?.add(Person("Ann", "Lace", "ordinary girl", R.drawable.lavery))
            persons?.add(Person("Lillie", "Watts", "pretty woman", R.drawable.lillie))
            persons?.add(Person("Columbia", ", the country of", "best country", R.drawable.columbia))
        }
    }

    private fun initializeAdapter() {
        val adapter = Adapter1(persons!!)
        rv?.adapter = adapter
    }
}
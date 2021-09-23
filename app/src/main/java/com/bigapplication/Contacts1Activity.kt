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

        //Добавляем слушателя нажатий по кнопке Button:
        addLink?.setOnClickListener { //Получаем вид с файла prompt.xml, который применим для диалогового окна:
            val li = LayoutInflater.from(context)
            val promptsView = li.inflate(R.layout.prompt, null)

            //Создаем AlertDialog
            val mDialogBuilder = AlertDialog.Builder(context)

            //Настраиваем prompt.xml для нашего AlertDialog:
            mDialogBuilder.setView(promptsView)

            //Настраиваем отображение поля для ввода текста в открытом диалоге:
            val userInput = promptsView.findViewById<View>(R.id.input_text) as EditText

            //Настраиваем сообщение в диалоговом окне:
            mDialogBuilder
//                .setTitle("Add contact")
                .setCancelable(true)
                .setPositiveButton(
                    "OK"
                ) { dialog, id -> //Вводим текст и отображаем в строке ввода на основном экране:
                    finalText?.text = userInput.text
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
        repeat(7) {
            persons?.add(Person("Emma Wilson", "23 years old", R.drawable.emma))
            persons?.add(Person("Ann Lace", "25 years old", R.drawable.lavery))
            persons?.add(Person("Lillie Watts", "35 years old", R.drawable.lillie))
            persons?.add(Person("Columbia", "202 years old", R.drawable.columbia))
        }
    }

    private fun initializeAdapter() {
        val adapter = Adapter1(persons!!)
        rv?.adapter = adapter
    }
}
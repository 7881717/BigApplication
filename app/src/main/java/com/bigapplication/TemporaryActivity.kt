package com.bigapplication

import android.app.AlertDialog
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.EditText
import android.view.View
import android.widget.Button

class TemporaryActivity : AppCompatActivity() {
    val context: Context = this
    private var button: Button? = null
    private var final_text: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_temporary)

        //Инициализируем элементы:
        button = findViewById<View>(R.id.prompt_button) as Button
        final_text = findViewById<View>(R.id.final_text) as TextView

        //Добавляем слушателя нажатий по кнопке Button:
        button?.setOnClickListener { //Получаем вид с файла prompt.xml, который применим для диалогового окна:
            val li = LayoutInflater.from(context)
            val promptsView = li.inflate(R.layout.prompt, null)

            //Создаем AlertDialog
            val mDialogBuilder = AlertDialog.Builder(context)

            //Настраиваем prompt.xml для нашего AlertDialog:
            mDialogBuilder.setView(promptsView)

            //Настраиваем отображение поля для ввода текста в открытом диалоге:
            val userInput = promptsView.findViewById<View>(R.id.editTextName) as EditText

            //Настраиваем сообщение в диалоговом окне:
            mDialogBuilder
                .setCancelable(true)
                .setPositiveButton(
                    "OK"
                ) { dialog, id -> //Вводим текст и отображаем в строке ввода на основном экране:
                    final_text?.text = userInput.text
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
}
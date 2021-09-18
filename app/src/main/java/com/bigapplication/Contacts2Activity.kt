package com.bigapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Contacts2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contacts2)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerViewOld)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = Adapter2(getCatList())

    }

    private fun fillList(): List<String> {
        val data = mutableListOf<String>()
        for (i in 0..30) {
            data.add("$i element")
        }
        return data
    }

    private fun getCatList(): List<String> {
        return this.resources.getStringArray(R.array.cat_names).toList()
    }

}
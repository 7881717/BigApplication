package com.bigapplication



import android.view.LayoutInflater
import android.view.View

import android.view.ViewGroup
import android.widget.ImageView

import androidx.recyclerview.widget.RecyclerView

import android.widget.TextView

import androidx.cardview.widget.CardView


class Adapter1 internal constructor(var persons: List<Person>) :
    RecyclerView.Adapter<Adapter1.PersonViewHolder>() {
    class PersonViewHolder internal constructor(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var cv: CardView
        var personName: TextView
        var personAge: TextView
        var personPhoto: ImageView

        init {
            cv = itemView.findViewById(R.id.cv)
            personName = itemView.findViewById(R.id.person_name)
            personAge = itemView.findViewById(R.id.person_age)
            personPhoto = itemView.findViewById(R.id.person_photo) as ImageView
        }
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): PersonViewHolder {
        val v: View =
            LayoutInflater.from(viewGroup.context).inflate(R.layout.item, viewGroup, false)
        return PersonViewHolder(v)
    }

    override fun onBindViewHolder(personViewHolder: PersonViewHolder, i: Int) {
        personViewHolder.personName.text = persons[i].name
        personViewHolder.personAge.text = persons[i].age
        personViewHolder.personPhoto.setImageResource(persons[i].photoId)
    }

    override fun getItemCount(): Int {
        return persons.size
    }
}
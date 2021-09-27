package com.bigapplication



import android.view.LayoutInflater
import android.view.View

import android.view.ViewGroup
import android.widget.ImageView

import androidx.recyclerview.widget.RecyclerView

import android.widget.TextView
import android.widget.Toast

import androidx.cardview.widget.CardView
import com.bumptech.glide.Glide









class Adapter1 internal constructor(var persons: List<Person>) :
    RecyclerView.Adapter<Adapter1.PersonViewHolder>() {
    class PersonViewHolder internal constructor(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var cv: CardView
        var personNameSurname: TextView
        var personAge: TextView
        var personPhoto: ImageView
        var imgViewRemoveIcon: ImageView

        init {
            cv = itemView.findViewById(R.id.cv)
            personNameSurname = itemView.findViewById(R.id.person_name_surname)
            personAge = itemView.findViewById(R.id.person_age)
            personPhoto = itemView.findViewById(R.id.person_photo) as ImageView
            imgViewRemoveIcon = itemView.findViewById(R.id.imageViewTrashCan) as ImageView

        }
    }


    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): PersonViewHolder {
        val v: View =
            LayoutInflater.from(viewGroup.context).inflate(R.layout.item1, viewGroup, false)
        return PersonViewHolder(v)
    }

    override fun onBindViewHolder(personViewHolder: PersonViewHolder, i: Int) {
        personViewHolder.personNameSurname.text = persons[i].name + " " + persons[i].surname
        personViewHolder.personAge.text = persons[i].career
        Glide.with(personViewHolder.personPhoto)
            .load("https://i.pravatar.cc/300?img=$i")
            .error(persons[i].photoId)
            .circleCrop()
            .into(personViewHolder.personPhoto)
//        personViewHolder.personPhoto.setImageResource(persons[i].photoId)

        personViewHolder.imgViewRemoveIcon.setOnClickListener { view ->

            // trash can clicked.
            // start your activity here
            Toast.makeText( personViewHolder.imgViewRemoveIcon.context,""+i,Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return persons.size
    }




}
package com.example.bigapplication.list

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.bigapplication.R

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

package com.bigapplication.ui.contacts.adapter.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.bigapplication.databinding.ItemBinding
import com.bigapplication.model.Contact
import com.bigapplication.ui.contacts.adapter.listeners.IContactClickListener
import com.bigapplication.utils.ext.loadImage
import com.bumptech.glide.Glide

class PersonViewHolder internal constructor(
    private val binding: ItemBinding,
    private val onIContactClickListener: IContactClickListener
) :
    RecyclerView.ViewHolder(binding.root) {

    fun bindTo(contact: Contact) {

        val text = contact.name + " " + contact.surname
        binding.personNameSurname.text = text
        binding.personAge.text = contact.career
//      Glide except this: personPhoto.setImageResource(persons[i].photoId)


        binding.personPhoto.loadImage("https://i.pravatar.cc/300?img=$absoluteAdapterPosition", contact.photoId)

        setListeners()
    }

    private fun setListeners() {
        binding.imageViewTrashCan.setOnClickListener {
            onIContactClickListener.removeContact(absoluteAdapterPosition)
        }
    }

//    var cv: CardView
//    var personNameSurname: TextView
//    var personAge: TextView
//    var personPhoto: ImageView
//    var imgViewRemoveIcon: ImageView
//
//
//    init {
//        cv = itemView.findViewById(R.id.cv)
//        personNameSurname = itemView.findViewById(R.id.person_name_surname)
//        personAge = itemView.findViewById(R.id.person_age)
//        personPhoto = itemView.findViewById(R.id.person_photo) as ImageView
//        imgViewRemoveIcon = itemView.findViewById(R.id.imageViewTrashCan) as ImageView
//
//    }
}


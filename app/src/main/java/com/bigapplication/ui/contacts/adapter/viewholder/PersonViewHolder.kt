package com.bigapplication.ui.contacts.adapter.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.bigapplication.databinding.ItemBinding
import com.bigapplication.model.User
import com.bigapplication.ui.contacts.adapter.listeners.IContactClickListener
import com.bumptech.glide.Glide

class PersonViewHolder internal constructor(
    private val binding: ItemBinding,
    private val onIContactClickListener: IContactClickListener
) :
    RecyclerView.ViewHolder(binding.root) {

    fun bindTo(user: User, position: Int) {

        val text = user.name + " " + user.surname
        binding.personNameSurname.text = text
        binding.personAge.text = user.career
//      Glide except this: personPhoto.setImageResource(persons[i].photoId)
        Glide.with(binding.personPhoto)
            .load("https://i.pravatar.cc/300?img=$position")
            .error(user.photoId)
            .circleCrop()
            .into(binding.personPhoto)

        setListeners(position)
    }

    private fun setListeners(position: Int) {
        binding.imageViewTrashCan.setOnClickListener {
            onIContactClickListener.removeContact(position)
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
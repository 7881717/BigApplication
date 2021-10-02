package com.bigapplication.utils.ext

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.loadImage(imagePath: String, photoId: Int) {
    Glide.with(this)
        .load(imagePath)
        .error(photoId)
        .circleCrop()
        .into(this)
}


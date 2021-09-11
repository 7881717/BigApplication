package com.example.bigapplication

import java.util.*

data class Person(
    var name: String,
    var age: String,
    var photoId: Int,
    var id: String = UUID.randomUUID().toString()
)
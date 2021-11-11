package com.bigapplication.utils

import android.util.Log

fun tracing(tracingString: String) {
    Log.d("", tracingString)

    val message: (Int) -> Int
    message = ::hello
    message(7)
}

fun hello(inbound: Int): Int{
    println("Hello Kotlin")
    return inbound * 7
}





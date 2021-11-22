package com.bigapplication.model

import com.bigapplication.R

data class Contact constructor(
    var _iD: Int,
    var _name: String = "John",
    var _surname: String = "Johnson",
    var _career: String = "trainee",
    var _photoId: Int = R.drawable.brazilia
): Any() {
    var name = _name
        set(value) {
            field = if (value != "")
                value
            else {
                "John"
            }
        }
    var surname = _surname
    var career = _career

    init {
        name = _name
        surname = if (_surname != "")
            _surname
        else {
            "Johnson"
        }
        career = if (_career != "")
            _career
        else {
            "trainee"
        }
    }
}
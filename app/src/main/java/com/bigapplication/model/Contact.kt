package com.bigapplication.model

import com.bigapplication.R

//fixme user data class!
data class Contact constructor(
    var _iD: Int,
    var _name: String = "John",
    var _surname: String = "Johnson",
    var _career: String = "trainee",
    var _photoId: Int = R.drawable.brazilia
) {
    var name = _name
        set(value) {
            field = if (value.length > 2)
                value+"!!!"
            else {
                "John"
            }
        }
    var surname = _surname
        set(value) {
            if (!value.isNullOrBlank()) field = value+"!!!"
        }
    var career = _career

    init {
        name = if (_name.isNotEmpty())
            _name
        else {
            "John"
        }
        surname = if (_surname.isNotBlank())
            _surname
        else {
            "Johnson"
        }
        career = if (!_career.isNullOrEmpty())
            _career
        else {
            "trainee"
        }
    }
}

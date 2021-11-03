package com.bigapplication.ui.customview

import android.content.Context
import android.util.AttributeSet
import com.bigapplication.R
import com.google.android.material.button.MaterialButton

class CustomButton @JvmOverloads

constructor(context: Context,
            attrs: AttributeSet? = null,
            defStyleAttr: Int = R.style.MyButtonStyle) :
    MaterialButton(
        context, attrs, defStyleAttr
    )
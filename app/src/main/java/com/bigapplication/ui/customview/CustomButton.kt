package com.bigapplication.ui.customview

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatButton
import com.bigapplication.R


class CustomButton @JvmOverloads

constructor(context: Context,
            attrs: AttributeSet? = null,
            defStyleAttr: Int = R.style.MyButtonStyle) :
    AppCompatButton(
        context, attrs, defStyleAttr
    )
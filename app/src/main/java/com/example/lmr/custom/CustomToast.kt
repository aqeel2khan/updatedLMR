package com.example.lmr.custom

import android.content.Context
import android.widget.Toast

class CustomToast {
    companion object{
        fun Context.showToast(message: CharSequence?) = Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

    }
}
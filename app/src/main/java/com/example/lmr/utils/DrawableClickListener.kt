package com.example.lmr.utils


interface DrawableClickListener {

    enum class DrawablePosition {
        TOP, BOTTOM, START, END
    }

    fun onClick(target: DrawablePosition)
}
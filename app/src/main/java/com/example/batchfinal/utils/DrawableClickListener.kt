package com.example.batchfinal.utils


interface DrawableClickListener {

    enum class DrawablePosition {
        TOP, BOTTOM, START, END
    }

    fun onClick(target: DrawablePosition)
}
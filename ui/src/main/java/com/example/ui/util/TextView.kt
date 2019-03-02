package com.example.ui.util

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.widget.TextView
import java.util.*


fun TextView.autoGenBackground() {
    val rd = Random()
    val rRandom = rd.nextInt(255)
    val bRandom = rd.nextInt(255)
    val gRandom = rd.nextInt(255)
    val gd = GradientDrawable()
    gd.setColor(
        Color.argb(
            188,
            rRandom,
            bRandom,
            gRandom
        )
    )
    gd.cornerRadius = 15f
    this.setBackgroundDrawable(gd)
}
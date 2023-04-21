package com.mynotes.resources.themes

import android.annotation.SuppressLint
import androidx.compose.ui.graphics.Color

data class MyNotesColors(
    val primaryColor: Color,
    val secondaryColor: Color,
    val transparent: Color,
    val editTextBackgroundColor: Color,
    val textColor: Color
)

@SuppressLint("InvalidColorHexValue")
val basePalette = MyNotesColors(
    primaryColor = Color(color = 0xFFFFB151),
    secondaryColor = Color(color = 0xFFB16E1C),
    transparent = Color(color = 0x0),
    editTextBackgroundColor = Color(color = 0xFFFFE1BB),
    textColor = Color(color = 0xFF463C2F)
)

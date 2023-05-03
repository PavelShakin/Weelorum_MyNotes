package com.mynotes.resources.themes

import android.annotation.SuppressLint
import androidx.compose.ui.graphics.Color

data class MyNotesColors(
    val primaryColor: Color,
    val secondaryColor: Color,
    val transparent: Color,
    val backgroundColor: Color,
    val textColor: Color,
    val dividerColor: Color,
    val dismissColor: Color,
    val disabledButtonColor: Color,
    val errorColor: Color,
    val borderStrokeColor: Color
)

@SuppressLint("InvalidColorHexValue")
val basePalette = MyNotesColors(
    primaryColor = Color(color = 0xFFFFB151),
    secondaryColor = Color(color = 0xFFB16E1C),
    transparent = Color(color = 0x0),
    backgroundColor = Color(color = 0xFFFFE1BB),
    textColor = Color(color = 0xFF463C2F),
    dividerColor = Color(color = 0xFF776242),
    dismissColor = Color(color = 0xFFA74939),
    disabledButtonColor = Color(color = 0x80FFB151),
    errorColor = Color(color = 0xFFCF3E3E),
    borderStrokeColor = Color(color = 0x80774D19),
)

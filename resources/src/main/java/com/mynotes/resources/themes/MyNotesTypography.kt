package com.mynotes.resources.themes

import androidx.compose.ui.text.TextStyle

data class MyNotesTypography(
    val title: TextStyle
)

val baseTypography = MyNotesTypography(
    title = TextStyle(
        color = basePalette.primaryColor
    )
)

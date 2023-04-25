package com.mynotes.resources.themes

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val textHugeSize = 20.sp
val textMediumSize = 16.sp
val textSmallSize = 12.sp

data class MyNotesTypography(
    val title: TextStyle,
    val placeholder: TextStyle,
    val button: TextStyle,
    val alertTitle: TextStyle,
    val alertSubtitle: TextStyle,
    val dismissButton: TextStyle
)

val baseTypography = MyNotesTypography(
    title = TextStyle(
        color = basePalette.primaryColor
    ),
    placeholder = TextStyle(
        color = basePalette.primaryColor,
        fontSize = textMediumSize
    ),
    button = TextStyle(
        color = basePalette.textColor,
        fontSize = textMediumSize,
        fontWeight = FontWeight.SemiBold
    ),
    alertTitle = TextStyle(
        color = basePalette.textColor,
        fontSize = textMediumSize,
        fontWeight = FontWeight.Bold
    ),
    alertSubtitle = TextStyle(
        color = basePalette.textColor,
        fontSize = textMediumSize
    ),
    dismissButton = TextStyle(
        color = basePalette.dismissColor,
        fontSize = textMediumSize,
        fontWeight = FontWeight.SemiBold
    )
)

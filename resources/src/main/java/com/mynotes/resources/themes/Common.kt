package com.mynotes.resources.themes

import androidx.compose.runtime.staticCompositionLocalOf

val LocalMyNotesColors = staticCompositionLocalOf<MyNotesColors> {
    error("No colors provided")
}

val LocalMyNotesTypography = staticCompositionLocalOf<MyNotesTypography> {
    error("No font provided")
}

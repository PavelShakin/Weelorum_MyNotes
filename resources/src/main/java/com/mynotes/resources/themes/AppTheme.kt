package com.mynotes.resources.themes

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable

object MyNotesTheme {
    val colors: MyNotesColors
        @Composable
        @ReadOnlyComposable
        get() = LocalMyNotesColors.current

    val typography: MyNotesTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalMyNotesTypography.current
}

@Composable
fun AppTheme(content: @Composable () -> Unit) {
    CompositionLocalProvider(
        LocalMyNotesColors provides basePalette,
        LocalMyNotesTypography provides baseTypography,
        content = content
    )
}

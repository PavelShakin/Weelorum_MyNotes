package com.mynotes.resources.widgets

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.mynotes.resources.themes.MyNotesTheme

object EditTextWidgets {

    @Composable
    fun EditTextWidget(
        value: TextFieldValue,
        onValueChange: (TextFieldValue) -> Unit
    ) {
        TextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = value,
            onValueChange = onValueChange,
            shape = RoundedCornerShape(10.dp),
            colors = TextFieldDefaults.textFieldColors(
                textColor = MyNotesTheme.colors.textColor,
                backgroundColor = MyNotesTheme.colors.backgroundColor,
                cursorColor = MyNotesTheme.colors.textColor,
                disabledIndicatorColor = MyNotesTheme.colors.transparent,
                focusedIndicatorColor = MyNotesTheme.colors.transparent,
                unfocusedIndicatorColor = MyNotesTheme.colors.transparent,
            )
        )
    }
}

package com.mynotes.resources.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.mynotes.resources.widgets.ButtonWidgets.ButtonWidget
import com.mynotes.resources.widgets.EditTextWidgets.EditTextWidget
import com.mynotes.resources.widgets.Utils.SpacerVerticalView
import com.mynotes.resources.widgets.Utils.SpacerWeightView

@Composable
fun EditNoteComponent(
    titleValue: TextFieldValue,
    onTitleValueChange: (TextFieldValue) -> Unit,
    noteValue: TextFieldValue,
    onNoteValueChange: (TextFieldValue) -> Unit,
    buttonEnabled: Boolean,
    onBackClick: () -> Unit,
    onSaveClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .padding(20.dp)
        ) {
            Column(
                modifier = Modifier
                    .weight(0.5f)
            ) {
                EditTextWidget(
                    value = titleValue,
                    onValueChange = onTitleValueChange
                )
                SpacerVerticalView()
                EditTextWidget(
                    value = noteValue,
                    onValueChange = onNoteValueChange
                )
            }
            SpacerWeightView()
            ButtonWidget(
                onClick = { onSaveClick.invoke() },
                enabled = buttonEnabled,
                text = ""
            )
        }
    }
}

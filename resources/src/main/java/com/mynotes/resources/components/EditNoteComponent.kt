package com.mynotes.resources.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.mynotes.resources.R
import com.mynotes.resources.widgets.ButtonWidgets.ButtonWidget
import com.mynotes.resources.widgets.DialogWidgets.DeleteNoteDialog
import com.mynotes.resources.widgets.DialogWidgets.EmptyNoteAlertDialog
import com.mynotes.resources.widgets.EditTextWidgets.EditTextWidget
import com.mynotes.resources.widgets.Utils.SpacerVerticalView
import com.mynotes.resources.widgets.Utils.SpacerWeightView

@Composable
fun EditNoteComponent(
    titleValue: TextFieldValue,
    onTitleValueChange: (TextFieldValue) -> Unit,
    noteValue: TextFieldValue,
    onNoteValueChange: (TextFieldValue) -> Unit,
    buttonEnabled: Boolean = false,
    onSaveClick: () -> Unit,
    isGoBackDialogShowing: Boolean = false,
    isDeleteDialogShowing: Boolean = false,
    onNavigateToNotesScreenClick: () -> Unit,
    onDeleteNoteClick: () -> Unit,
    onCancelDialogClick: () -> Unit,
    isError: Boolean,
    errorText: Int? = null
) {
    if (isGoBackDialogShowing) {
        EmptyNoteAlertDialog(
            title = stringResource(id = R.string.dialog_note_empty_title),
            subtitle = stringResource(id = R.string.dialog_note_empty_subtitle),
            dismissText = stringResource(id = R.string.action_go_back),
            confirmText = stringResource(id = R.string.action_continue),
            onDismissClick = { onNavigateToNotesScreenClick.invoke() },
            onConfirmClick = { onCancelDialogClick.invoke() }
        )
    }
    if (isDeleteDialogShowing) {
        DeleteNoteDialog(
            title = stringResource(id = R.string.dialog_delete_note_title),
            subtitle = stringResource(id = R.string.dialog_delete_note_subtitle),
            dismissText = stringResource(id = R.string.action_cancel),
            confirmText = stringResource(id = R.string.action_delete),
            onDismissClick = { onCancelDialogClick.invoke() },
            onConfirmClick = { onDeleteNoteClick.invoke() }
        )
    }
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
                    .fillMaxHeight(0.65f)
                    .padding(bottom = 60.dp)
            ) {
                EditTextWidget(
                    value = titleValue,
                    onValueChange = onTitleValueChange
                )
                SpacerVerticalView()
                EditTextWidget(
                    value = noteValue,
                    onValueChange = onNoteValueChange,
                    isError = isError,
                    errorText = errorText?.let { stringResource(id = it) }
                )
            }
            SpacerWeightView()
            ButtonWidget(
                onClick = {
                    onSaveClick.invoke()
                },
                enabled = buttonEnabled,
                text = stringResource(id = R.string.action_save),
            )
        }
    }
}

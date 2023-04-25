package com.mynotes.notes.screens.createNote

import com.mynotes.core.common.GlobalConstraints.emptyString

sealed class CreateNoteViewState {
    data class State(
        val title: String = emptyString,
        val note: String = emptyString,
        val buttonEnabled: Boolean = false,
        val isAlertShowing: Boolean = false
    ) : CreateNoteViewState()
}

sealed class CreateNoteAction {
    object NextPage : CreateNoteAction()
}

sealed class CreateNoteEvent {
    object OnBackPressed : CreateNoteEvent()
    data class UpdateTitle(val value: String) : CreateNoteEvent()
    data class UpdateNote(val value: String) : CreateNoteEvent()
    object Save : CreateNoteEvent()
    object NavigateToNotesScreen : CreateNoteEvent()
    object Continue : CreateNoteEvent()
}

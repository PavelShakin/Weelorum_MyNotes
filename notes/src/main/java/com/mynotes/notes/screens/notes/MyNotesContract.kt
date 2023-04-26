package com.mynotes.notes.screens.notes

import com.mynotes.core.models.view.NoteViewData

sealed class MyNotesViewState {

    data class State(
        val isLoading: Boolean = false,
        val notes: List<NoteViewData> = emptyList()
    ) : MyNotesViewState()
}

sealed class MyNotesAction

sealed class MyNotesEvent {

    object Load : MyNotesEvent()
}

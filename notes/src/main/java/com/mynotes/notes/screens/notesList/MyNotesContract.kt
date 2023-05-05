package com.mynotes.notes.screens.notesList

import com.mynotes.core.models.view.NoteViewData

sealed class MyNotesViewState {

    data class State(
        val isLoading: Boolean = false,
        val notes: List<NoteViewData> = emptyList()
    ) : MyNotesViewState()
}

sealed class MyNotesAction {
    data class GoToNoteDetails(val note: NoteViewData? = null) : MyNotesAction()
}

sealed class MyNotesEvent {
    object Load : MyNotesEvent()
    data class OnNoteClick(val note: NoteViewData) : MyNotesEvent()
    data class OnNoteSelect(val note: NoteViewData) : MyNotesEvent()
    object CreateNote : MyNotesEvent()
}

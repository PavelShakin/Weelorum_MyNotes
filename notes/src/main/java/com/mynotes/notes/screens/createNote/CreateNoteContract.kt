package com.mynotes.notes.screens.createNote

import com.mynotes.core.common.GlobalConstraints.emptyString

sealed class CreateNoteViewState {
    data class State(
        val title: String = emptyString,
        val note: String = emptyString
    ) : CreateNoteViewState()
}

sealed class CreateNoteAction

sealed class CreateNoteEvent

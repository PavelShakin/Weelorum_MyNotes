package com.mynotes.notes.screens.createNote

import com.mynotes.core.views.BaseViewModel
import javax.inject.Inject

class CreateNoteViewModel @Inject constructor() : BaseViewModel<CreateNoteViewState, CreateNoteAction>() {

    init {
        viewState = CreateNoteViewState.State()
    }
}

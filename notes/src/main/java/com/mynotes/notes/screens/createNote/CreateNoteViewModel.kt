package com.mynotes.notes.screens.createNote

import androidx.lifecycle.viewModelScope
import com.mynotes.core.contracts.handlers.EventHandler
import com.mynotes.core.views.BaseViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class CreateNoteViewModel @Inject constructor() :
    BaseViewModel<CreateNoteViewState, CreateNoteAction>(),
    EventHandler<CreateNoteEvent> {

    init {
        viewState = CreateNoteViewState.State()
    }

    override fun obtainEvent(event: CreateNoteEvent) {
        when (event) {
            is CreateNoteEvent.OnBackPressed -> reduceOnBackPress()
            is CreateNoteEvent.UpdateTitle -> reduceUpdateTitle(event.value)
            is CreateNoteEvent.UpdateNote -> reduceUpdateNote(event.value)
            is CreateNoteEvent.Save -> reduceSaveNote()
            is CreateNoteEvent.NavigateToNotesScreen -> reduceNavigateToNotesScreen()
            is CreateNoteEvent.Continue -> reduceContinueNoteCreation()
        }
    }

    private fun reduceOnBackPress() {
        if (viewState is CreateNoteViewState.State) {
            val state = (viewState as CreateNoteViewState.State)
            viewState = state.copy(isAlertShowing = true)
        }
    }

    private fun reduceUpdateTitle(title: String) {
        if (viewState is CreateNoteViewState.State) {
            val state = (viewState as CreateNoteViewState.State)
            viewState = state.copy(title = title)
        }
    }

    private fun reduceUpdateNote(note: String) {
        if (viewState is CreateNoteViewState.State) {
            val state = (viewState as CreateNoteViewState.State)
            viewState = state.copy(
                note = note,
                buttonEnabled = note.isNotEmpty()
            )
        }
    }

    private fun reduceSaveNote() {
        viewModelScope.launch {
            if (viewState is CreateNoteViewState.State) {
                val state = (viewState as CreateNoteViewState.State)
                viewAction = CreateNoteAction.NextPage
            }
        }
    }

    private fun reduceNavigateToNotesScreen() {
        if (viewState is CreateNoteViewState.State) {
            val state = (viewState as CreateNoteViewState.State)
            viewState = state.copy(isAlertShowing = false)
            viewAction = CreateNoteAction.NextPage
        }
    }

    private fun reduceContinueNoteCreation() {
        if (viewState is CreateNoteViewState.State) {
            val state = (viewState as CreateNoteViewState.State)
            viewState = state.copy(isAlertShowing = false)
        }
    }
}

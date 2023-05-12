package com.mynotes.notes.screens.notesList

import androidx.lifecycle.viewModelScope
import com.mynotes.core.contracts.dispatchers.ICoroutineDispatchers
import com.mynotes.core.contracts.handlers.EventHandler
import com.mynotes.core.models.view.NoteViewData
import com.mynotes.core.usecases.note.INoteUseCase
import com.mynotes.core.views.BaseViewModel
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MyNotesViewModel @Inject constructor(
    private val defaultDispatchers: ICoroutineDispatchers,
    private val noteUseCase: INoteUseCase
) : BaseViewModel<MyNotesViewState, MyNotesAction>(),
    EventHandler<MyNotesEvent> {

    init {
        viewState = MyNotesViewState.State(true)
    }

    override fun obtainEvent(event: MyNotesEvent) {
        when (event) {
            is MyNotesEvent.Load -> reduceLoad()
            is MyNotesEvent.OnNoteClick -> reduceGoToNoteDetails(event.note)
            is MyNotesEvent.OnNoteSelect -> reduceSelectNote(event.note)
            is MyNotesEvent.DeleteSelectedNotes -> reduceDeleteSelectedNotes()
            is MyNotesEvent.CancelSelection -> reduceCancelSelection()
            is MyNotesEvent.CreateNote -> reduceCreateNote()
        }
    }

    private fun reduceLoad() {
        viewModelScope.launch {
            val notes = withContext(defaultDispatchers.io) {
                noteUseCase.getNotes()
            }
            if (viewState is MyNotesViewState.State) {
                val state = (viewState as MyNotesViewState.State)
                viewState = state.copy(
                    isLoading = false,
                    notes = notes
                )
            }
        }
    }

    private fun reduceGoToNoteDetails(note: NoteViewData) {
        viewAction = MyNotesAction.GoToNoteDetails(note)
    }

    private fun reduceSelectNote(note: NoteViewData) {
        if (viewState is MyNotesViewState.State) {
            val state = (viewState as MyNotesViewState.State)
            val updatedList = state.selectedNotes
            if (updatedList.contains(note)) {
                updatedList.remove(note)
            } else {
                updatedList.add(note)
            }
            viewState = state.copy(
                selectedNotes = updatedList,
                isSelectMultipleMode = updatedList.isNotEmpty()
            )
        }
    }

    private fun reduceDeleteSelectedNotes() {
        viewModelScope.launch {
            if (viewState is MyNotesViewState.State) {
                val state = (viewState as MyNotesViewState.State)
                noteUseCase.deleteNote(state.selectedNotes)
                val updatedNotes = noteUseCase.getNotes()
                viewState = state.copy(
                    notes = updatedNotes,
                    selectedNotes = mutableListOf(),
                    isSelectMultipleMode = false
                )
            }
        }
    }

    private fun reduceCancelSelection() {
        if (viewState is MyNotesViewState.State) {
            val state = (viewState as MyNotesViewState.State)
            viewState = state.copy(
                selectedNotes = mutableListOf(),
                isSelectMultipleMode = false
            )
        }
    }

    private fun reduceCreateNote() {
        viewAction = MyNotesAction.GoToNoteDetails()
    }
}

package com.mynotes.notes.screens.noteDetails

import androidx.lifecycle.viewModelScope
import com.mynotes.core.contracts.generators.INoteTitleGenerator
import com.mynotes.core.contracts.handlers.EventHandler
import com.mynotes.core.contracts.validators.INoteValidator
import com.mynotes.core.models.view.NoteViewData
import com.mynotes.core.usecases.note.INoteUseCase
import com.mynotes.core.views.BaseViewModel
import kotlinx.coroutines.launch
import java.util.UUID
import javax.inject.Inject

class NoteDetailsViewModel @Inject constructor(
    private val noteUseCase: INoteUseCase,
    private val validator: INoteValidator,
    private val titleGenerator: INoteTitleGenerator
) :
    BaseViewModel<NoteDetailsViewState, NoteDetailsAction>(),
    EventHandler<NoteDetailsEvent> {

    init {
        viewState = NoteDetailsViewState.State(isLoading = true)
    }

    override fun obtainEvent(event: NoteDetailsEvent) {
        when (event) {
            is NoteDetailsEvent.Load -> reduceLoad(event)
            is NoteDetailsEvent.OnBackPressed -> reduceOnBackPress()
            is NoteDetailsEvent.ShowDeleteDialog -> reduceShowDeleteDialog()
            is NoteDetailsEvent.UpdateTitle -> reduceUpdateTitle(event.value)
            is NoteDetailsEvent.UpdateNoteDetails -> reduceUpdateNote(event.value)
            is NoteDetailsEvent.Save -> reduceSaveNote()
            is NoteDetailsEvent.NavigateToNotesScreen -> reduceNavigateToNotesScreen()
            is NoteDetailsEvent.CancelDialog -> reduceCancelDialog()
            is NoteDetailsEvent.DeleteNote -> reduceDeleteNote()
        }
    }

    private fun reduceLoad(event: NoteDetailsEvent.Load) {
        viewModelScope.launch {
            if (viewState is NoteDetailsViewState.State) {
                val state = (viewState as NoteDetailsViewState.State)
                viewState = if (event.noteId.isNotEmpty()) {
                    val note = noteUseCase.getNoteById(event.noteId)
                    state.copy(
                        noteId = note.id,
                        title = note.title,
                        description = note.description,
                        actual = note,
                        isLoading = false,
                        isEditMode = true
                    )
                } else {
                    state.copy(
                        isLoading = false,
                        isEditMode = false
                    )
                }
            }
        }
    }

    private fun reduceOnBackPress() {
        if (viewState is NoteDetailsViewState.State) {
            val state = (viewState as NoteDetailsViewState.State)
            viewState = state.copy(
                isGoBackDialogShowing = true
            )
        }
    }

    private fun reduceShowDeleteDialog() {
        if (viewState is NoteDetailsViewState.State) {
            val state = (viewState as NoteDetailsViewState.State)
            viewState = state.copy(
                isDeleteDialogShowing = true
            )
        }
    }

    private fun reduceUpdateTitle(title: String) {
        if (viewState is NoteDetailsViewState.State) {
            val state = (viewState as NoteDetailsViewState.State)
            viewState = state.copy(
                title = title
            )
        }
    }

    private fun reduceUpdateNote(description: String) {
        if (viewState is NoteDetailsViewState.State) {
            val state = (viewState as NoteDetailsViewState.State)
            val noteError = validator.noteIsValid(description)
            viewState = state.copy(
                description = description,
                noteError = noteError
            )
        }
    }

    private fun reduceSaveNote() {
        viewModelScope.launch {
            if (viewState is NoteDetailsViewState.State) {
                val state = (viewState as NoteDetailsViewState.State)
                if (state.title.isEmpty()) {
                    viewState = state.copy(title = titleGenerator.generateNoteTitle())
                }
                val updatedState = (viewState as NoteDetailsViewState.State)
                val note = NoteViewData(
                    id = updatedState.noteId.ifEmpty { UUID.randomUUID().toString() },
                    title = updatedState.title,
                    description = updatedState.description
                )
                noteUseCase.createNote(note)
                viewAction = NoteDetailsAction.Success
            }
        }
    }

    private fun reduceNavigateToNotesScreen() {
        if (viewState is NoteDetailsViewState.State) {
            val state = (viewState as NoteDetailsViewState.State)
            viewState = state.copy(isGoBackDialogShowing = false)
            viewAction = NoteDetailsAction.Success
        }
    }

    private fun reduceCancelDialog() {
        if (viewState is NoteDetailsViewState.State) {
            val state = (viewState as NoteDetailsViewState.State)
            viewState = state.copy(
                isGoBackDialogShowing = false,
                isDeleteDialogShowing = false
            )
        }
    }

    private fun reduceDeleteNote() {
        viewModelScope.launch {
            if (viewState is NoteDetailsViewState.State) {
                val state = (viewState as NoteDetailsViewState.State)
                val note = NoteViewData(
                    state.noteId,
                    state.title,
                    state.description
                )
                noteUseCase.deleteNote(note)
                viewAction = NoteDetailsAction.Success
            }
        }
    }
}

package com.mynotes.notes.screens.noteDetails

import com.mynotes.core.common.GlobalConstants.emptyString
import com.mynotes.core.models.view.NoteViewData

sealed class NoteDetailsViewState {
    data class State(
        val noteId: String = emptyString,
        val title: String = emptyString,
        val description: String = emptyString,
        val isGoBackDialogShowing: Boolean = false,
        val isDeleteDialogShowing: Boolean = false,
        val noteError: Int? = null,
        val actual: NoteViewData? = null,
        val isLoading: Boolean,
        val isEditMode: Boolean = false
    ) : NoteDetailsViewState() {

        fun buttonEnabled(): Boolean {
            val params: ArrayList<Boolean>
            if (isEditMode) {
                if (actual == null) return false
                else if (noteError != null) return false
                params = arrayListOf(
                    actual.title == title,
                    actual.description == description
                )
            } else {
                return description.isNotEmpty()
            }

            return params.any { !it }
        }
    }
}

sealed class NoteDetailsAction {
    object Success : NoteDetailsAction()
}

sealed class NoteDetailsEvent {
    data class Load(val noteId: String) : NoteDetailsEvent()
    object OnBackPressed : NoteDetailsEvent()
    object ShowDeleteDialog : NoteDetailsEvent()
    data class UpdateTitle(val value: String) : NoteDetailsEvent()
    data class UpdateNoteDetails(val value: String) : NoteDetailsEvent()
    object Save : NoteDetailsEvent()
    object NavigateToNotesScreen : NoteDetailsEvent()
    object CancelDialog : NoteDetailsEvent()
    object DeleteNote : NoteDetailsEvent()
}

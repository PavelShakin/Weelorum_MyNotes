package com.mynotes.core.usecases.note

import com.mynotes.core.models.view.NoteViewData

interface IGetNotesUseCase {

    suspend fun invoke(noteId: String): NoteViewData
    suspend fun invoke(): List<NoteViewData>
}

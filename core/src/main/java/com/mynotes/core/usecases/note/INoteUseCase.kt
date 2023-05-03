package com.mynotes.core.usecases.note

import com.mynotes.core.models.view.NoteViewData

interface INoteUseCase {

    suspend fun createNote(model: NoteViewData)
    suspend fun deleteNote(model: NoteViewData)
    suspend fun deleteNote(model: List<NoteViewData>)
    suspend fun getNoteById(noteId: String): NoteViewData
    suspend fun getNotes(): List<NoteViewData>
    suspend fun updateNote(model: NoteViewData)
}

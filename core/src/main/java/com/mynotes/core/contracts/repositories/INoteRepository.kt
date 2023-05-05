package com.mynotes.core.contracts.repositories

import com.mynotes.core.models.entities.NoteEntity

interface INoteRepository {

    suspend fun getNoteById(noteId: String): NoteEntity
    suspend fun getNotes(): List<NoteEntity>
    suspend fun create(model: NoteEntity)
    suspend fun update(model: NoteEntity)
    suspend fun delete(model: NoteEntity)
    suspend fun delete(model: List<NoteEntity>)
}

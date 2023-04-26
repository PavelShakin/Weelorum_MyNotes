package com.mynotes.core.usecases.note

import com.mynotes.core.models.entities.NoteEntity

interface IDeleteNoteUseCase {

    suspend fun invoke(model: NoteEntity)
    suspend fun invoke(model: List<NoteEntity>)
}

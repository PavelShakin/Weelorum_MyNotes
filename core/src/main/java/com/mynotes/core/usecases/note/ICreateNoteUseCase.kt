package com.mynotes.core.usecases.note

import com.mynotes.core.models.entities.NoteEntity

interface ICreateNoteUseCase {

    suspend fun invoke(model: NoteEntity)
}

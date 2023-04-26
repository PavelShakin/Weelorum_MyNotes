package com.mynotes.core.usecases.note

import com.mynotes.core.models.entities.NoteEntity

interface IUpdateNoteUseCase {

    suspend fun invoke(model: NoteEntity)
}

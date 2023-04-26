package com.mynotes.core.usecases.note

import com.mynotes.core.models.entities.NoteEntity

interface IGetNotesUseCase {

    suspend fun invoke(): List<NoteEntity>
}

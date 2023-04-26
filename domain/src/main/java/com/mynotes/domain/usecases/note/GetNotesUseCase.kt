package com.mynotes.domain.usecases.note

import com.mynotes.core.contracts.repositories.INoteRepository
import com.mynotes.core.models.entities.NoteEntity
import com.mynotes.core.usecases.note.IGetNotesUseCase
import javax.inject.Inject

class GetNotesUseCase @Inject constructor(
    private val repository: INoteRepository
) : IGetNotesUseCase {

    override suspend fun invoke(): List<NoteEntity> {
        return repository.getNotes()
    }
}

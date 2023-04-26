package com.mynotes.domain.usecases.note

import com.mynotes.core.contracts.repositories.INoteRepository
import com.mynotes.core.models.entities.NoteEntity
import com.mynotes.core.usecases.note.ICreateNoteUseCase
import javax.inject.Inject

class CreateNoteUseCase @Inject constructor(
    private val repository: INoteRepository
) : ICreateNoteUseCase {

    override suspend fun invoke(model: NoteEntity) {
        return repository.create(model)
    }
}

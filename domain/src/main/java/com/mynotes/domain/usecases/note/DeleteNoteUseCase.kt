package com.mynotes.domain.usecases.note

import com.mynotes.core.contracts.repositories.INoteRepository
import com.mynotes.core.models.entities.NoteEntity
import com.mynotes.core.usecases.note.IDeleteNoteUseCase
import javax.inject.Inject

class DeleteNoteUseCase @Inject constructor(
    private val repository: INoteRepository
) : IDeleteNoteUseCase {

    override suspend fun invoke(model: NoteEntity) {
        return repository.delete(model)
    }

    override suspend fun invoke(model: List<NoteEntity>) {
        return repository.delete(model)
    }
}

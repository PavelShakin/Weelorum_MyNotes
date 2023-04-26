package com.mynotes.domain.usecases.note

import com.mynotes.core.contracts.dispatchers.ICoroutineDispatchers
import com.mynotes.core.contracts.repositories.INoteRepository
import com.mynotes.core.models.entities.NoteEntity
import com.mynotes.core.usecases.note.IUpdateNoteUseCase
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UpdateNoteUseCase @Inject constructor(
    private val repository: INoteRepository,
    private val defaultDispatchers: ICoroutineDispatchers
) : IUpdateNoteUseCase {

    override suspend fun invoke(model: NoteEntity) {
        return withContext(defaultDispatchers.io) {
            repository.update(model)
        }
    }
}

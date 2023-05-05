package com.mynotes.domain.usecases.note

import com.mynotes.core.contracts.dispatchers.ICoroutineDispatchers
import com.mynotes.core.contracts.repositories.INoteRepository
import com.mynotes.core.models.mappers.NoteMapper
import com.mynotes.core.models.view.NoteViewData
import com.mynotes.core.usecases.note.IUpdateNoteUseCase
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UpdateNoteUseCase @Inject constructor(
    private val repository: INoteRepository,
    private val defaultDispatchers: ICoroutineDispatchers
) : IUpdateNoteUseCase {

    private val mapper = NoteMapper()
    override suspend fun invoke(model: NoteViewData) {
        return withContext(defaultDispatchers.io) {
            repository.update(mapper.fromDomain(model))
        }
    }
}

package com.mynotes.domain.usecases.note

import com.mynotes.core.contracts.repositories.INoteRepository
import com.mynotes.core.models.mappers.NoteMapper
import com.mynotes.core.models.view.NoteViewData
import com.mynotes.core.usecases.note.ICreateNoteUseCase
import javax.inject.Inject

class CreateNoteUseCase @Inject constructor(
    private val repository: INoteRepository
) : ICreateNoteUseCase {

    private val mapper = NoteMapper()
    override suspend fun invoke(model: NoteViewData) {
        return repository.create(mapper.fromDomain(model))
    }
}

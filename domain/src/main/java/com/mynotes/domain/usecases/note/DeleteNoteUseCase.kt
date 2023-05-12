package com.mynotes.domain.usecases.note

import com.mynotes.core.contracts.repositories.INoteRepository
import com.mynotes.core.models.mappers.NoteMapper
import com.mynotes.core.models.view.NoteViewData
import com.mynotes.core.usecases.note.IDeleteNoteUseCase
import javax.inject.Inject

class DeleteNoteUseCase @Inject constructor(
    private val repository: INoteRepository
) : IDeleteNoteUseCase {

    private val mapper = NoteMapper()
    override suspend fun invoke(model: NoteViewData) {
        return repository.delete(mapper.fromDomain(model))
    }

    override suspend fun invoke(model: List<NoteViewData>) {
        return repository.delete(model.map { mapper.fromDomain(it) })
    }
}

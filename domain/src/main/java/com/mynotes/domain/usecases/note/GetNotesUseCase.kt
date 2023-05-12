package com.mynotes.domain.usecases.note

import com.mynotes.core.contracts.repositories.INoteRepository
import com.mynotes.core.models.mappers.NoteMapper
import com.mynotes.core.models.view.NoteViewData
import com.mynotes.core.usecases.note.IGetNotesUseCase
import javax.inject.Inject

class GetNotesUseCase @Inject constructor(
    private val repository: INoteRepository
) : IGetNotesUseCase {

    private val mapper = NoteMapper()

    override suspend fun invoke(noteId: String): NoteViewData {
        return mapper.toDomain(repository.getNoteById(noteId))
    }

    override suspend fun invoke(): List<NoteViewData> {
        return repository.getNotes().map { mapper.toDomain(it) }
    }
}

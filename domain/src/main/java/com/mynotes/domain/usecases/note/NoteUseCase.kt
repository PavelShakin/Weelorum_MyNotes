package com.mynotes.domain.usecases.note

import com.mynotes.core.models.view.NoteViewData
import com.mynotes.core.usecases.note.ICreateNoteUseCase
import com.mynotes.core.usecases.note.IDeleteNoteUseCase
import com.mynotes.core.usecases.note.IGetNotesUseCase
import com.mynotes.core.usecases.note.INoteUseCase
import com.mynotes.core.usecases.note.IUpdateNoteUseCase
import javax.inject.Inject

class NoteUseCase @Inject constructor(
    private val createNoteUseCase: ICreateNoteUseCase,
    private val deleteNoteUseCase: IDeleteNoteUseCase,
    private val getNotesUseCase: IGetNotesUseCase,
    private val updateNoteUseCase: IUpdateNoteUseCase
) : INoteUseCase {

    override suspend fun createNote(model: NoteViewData) {
        createNoteUseCase.invoke(model)
    }

    override suspend fun deleteNote(model: NoteViewData) {
        deleteNoteUseCase.invoke(model)
    }

    override suspend fun deleteNote(model: List<NoteViewData>) {
        deleteNoteUseCase.invoke(model)
    }

    override suspend fun getNoteById(noteId: String): NoteViewData {
        return getNotesUseCase.invoke(noteId)
    }

    override suspend fun getNotes(): List<NoteViewData> {
        return getNotesUseCase.invoke()
    }

    override suspend fun updateNote(model: NoteViewData) {
        updateNoteUseCase.invoke(model)
    }
}

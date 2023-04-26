package com.mynotes.core.usecases.note

import com.mynotes.core.models.view.NoteViewData

interface IUpdateNoteUseCase {

    suspend fun invoke(model: NoteViewData)
}

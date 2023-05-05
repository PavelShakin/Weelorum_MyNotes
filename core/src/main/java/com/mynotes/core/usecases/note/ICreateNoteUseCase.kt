package com.mynotes.core.usecases.note

import com.mynotes.core.models.view.NoteViewData

interface ICreateNoteUseCase {

    suspend fun invoke(model: NoteViewData)
}

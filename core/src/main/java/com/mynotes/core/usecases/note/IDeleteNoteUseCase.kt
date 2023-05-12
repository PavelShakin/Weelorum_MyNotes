package com.mynotes.core.usecases.note

import com.mynotes.core.models.view.NoteViewData

interface IDeleteNoteUseCase {

    suspend fun invoke(model: NoteViewData)
    suspend fun invoke(model: List<NoteViewData>)
}

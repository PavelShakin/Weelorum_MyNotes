package com.mynotes.core.models.mappers

import com.mynotes.core.contracts.mappers.BaseMapper
import com.mynotes.core.models.entities.NoteEntity
import com.mynotes.core.models.view.NoteViewData

class NoteMapper : BaseMapper<NoteEntity, NoteViewData> {

    override fun toDomain(model: NoteEntity): NoteViewData {
        return NoteViewData(
            id = model.id,
            title = model.title,
            note = model.note
        )
    }

    override fun fromDomain(model: NoteViewData): NoteEntity {
        return NoteEntity(
            id = model.id,
            title = model.title,
            note = model.note
        )
    }
}

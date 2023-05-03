package com.mynotes.database.datasources

import com.mynotes.core.contracts.datasource.INoteLocalDataSource
import com.mynotes.core.models.daos.NoteDao
import com.mynotes.core.models.entities.NoteEntity
import javax.inject.Inject

class NoteLocalDataSource @Inject constructor(
    private val dao: NoteDao
) : INoteLocalDataSource {

    override fun getNote(noteId: String): NoteEntity {
        return dao.getNote(noteId)
    }

    override fun getList(): List<NoteEntity> {
        return dao.getList() ?: emptyList()
    }

    override fun create(model: NoteEntity) {
        dao.insert(model)
    }

    override fun update(model: NoteEntity) {
        dao.update(model)
    }

    override fun delete(model: NoteEntity) {
        dao.delete(model)
    }

    override fun delete(model: List<NoteEntity>) {
        dao.delete(model)
    }
}

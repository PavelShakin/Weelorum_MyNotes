package com.mynotes.core.contracts.datasource

import com.mynotes.core.contracts.datasource.base.ILocalDataSource
import com.mynotes.core.models.entities.NoteEntity

interface INoteLocalDataSource : ILocalDataSource<NoteEntity> {

    fun getList(): List<NoteEntity>
}

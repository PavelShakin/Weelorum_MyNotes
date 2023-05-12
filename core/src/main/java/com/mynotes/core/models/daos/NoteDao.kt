package com.mynotes.core.models.daos

import androidx.room.Dao
import androidx.room.Query
import com.mynotes.core.models.daos.base.BaseDao
import com.mynotes.core.models.entities.NoteEntity

@Dao
interface NoteDao : BaseDao<NoteEntity> {

    @Query("SELECT * FROM ${NoteEntity.TABLE} WHERE id = :noteId")
    fun getNote(noteId: String): NoteEntity
    @Query("SELECT * FROM ${NoteEntity.TABLE}")
    fun getList(): List<NoteEntity>?
}

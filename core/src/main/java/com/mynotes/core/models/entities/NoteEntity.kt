package com.mynotes.core.models.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.mynotes.core.models.entities.base.BaseEntity
import java.util.UUID

@Entity(tableName = NoteEntity.TABLE)
class NoteEntity(
    @PrimaryKey
    override val id: String = UUID.randomUUID().toString(),
    val title: String,
    val note: String
) : BaseEntity {

    companion object {
        const val TABLE = "notes"
    }
}

package com.mynotes.database.config

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mynotes.core.models.daos.NoteDao
import com.mynotes.core.models.entities.NoteEntity

@Database(
    entities = [
        NoteEntity::class
    ],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    companion object {
        const val DATABASE_NAME: String = "app_dp"
    }

    abstract fun getNoteDao(): NoteDao
}

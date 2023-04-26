package com.mynotes.database.di.modules

import android.app.Application
import androidx.room.Room
import com.mynotes.core.models.daos.NoteDao
import com.mynotes.database.config.AppDatabase
import dagger.Module
import dagger.Provides

@Module
class DatabaseModule {

    @Provides
    fun provideAppDatabase(application: Application): AppDatabase {
        return Room
            .databaseBuilder(application, AppDatabase::class.java, AppDatabase.DATABASE_NAME)
            .build()
    }

    @Provides
    fun provideNoteDao(db: AppDatabase): NoteDao {
        return db.getNoteDao()
    }
}

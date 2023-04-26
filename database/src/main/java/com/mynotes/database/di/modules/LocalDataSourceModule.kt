package com.mynotes.database.di.modules

import com.mynotes.core.contracts.datasource.INoteLocalDataSource
import com.mynotes.core.models.daos.NoteDao
import com.mynotes.database.datasources.NoteLocalDataSource
import dagger.Module
import dagger.Provides

@Module
class LocalDataSourceModule {

    @Provides
    fun provideINoteLocalDataSource(dao: NoteDao): INoteLocalDataSource {
        return NoteLocalDataSource(dao)
    }
}

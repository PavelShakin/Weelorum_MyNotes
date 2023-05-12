package com.mynotes.data.di.modules

import com.mynotes.core.contracts.dispatchers.ICoroutineDispatchers
import com.mynotes.core.contracts.repositories.INoteRepository
import com.mynotes.data.repositories.NoteRepository
import com.mynotes.database.datasources.NoteLocalDataSource
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @Provides
    fun provideNoteRepository(
        dataSource: NoteLocalDataSource,
        coroutineDispatchers: ICoroutineDispatchers,
    ): INoteRepository {
        return NoteRepository(
            dataSource,
            coroutineDispatchers
        )
    }
}

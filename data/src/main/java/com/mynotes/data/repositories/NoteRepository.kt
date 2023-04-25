package com.mynotes.data.repositories

import com.mynotes.core.contracts.dispatchers.ICoroutineDispatchers
import com.mynotes.core.contracts.repositories.INoteRepository
import com.mynotes.core.models.entities.NoteEntity
import com.mynotes.database.datasources.NoteLocalDataSource
import kotlinx.coroutines.withContext
import javax.inject.Inject

class NoteRepository @Inject constructor(
    private val localDataSource: NoteLocalDataSource,
    private val defaultDispatcher: ICoroutineDispatchers,
) : INoteRepository {
    override suspend fun getNotes(): List<NoteEntity> {
        return withContext(defaultDispatcher.io) {
            localDataSource.getList()
        }
    }

    override suspend fun create(model: NoteEntity) {
        return withContext(defaultDispatcher.io) {
            localDataSource.create(model)
        }
    }

    override suspend fun update(model: NoteEntity) {
        return withContext(defaultDispatcher.io) {
            localDataSource.update(model)
        }
    }

    override suspend fun delete(model: NoteEntity) {
        return withContext(defaultDispatcher.io) {
            localDataSource.delete(model)
        }
    }

    override suspend fun delete(model: List<NoteEntity>) {
        return withContext(defaultDispatcher.io) {
            localDataSource.delete(model)
        }
    }
}

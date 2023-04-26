package com.mynotes.domain.di.modules

import com.mynotes.core.contracts.dispatchers.ICoroutineDispatchers
import com.mynotes.core.contracts.repositories.INoteRepository
import com.mynotes.core.usecases.note.ICreateNoteUseCase
import com.mynotes.core.usecases.note.IDeleteNoteUseCase
import com.mynotes.core.usecases.note.IGetNotesUseCase
import com.mynotes.core.usecases.note.IUpdateNoteUseCase
import com.mynotes.domain.usecases.note.CreateNoteUseCase
import com.mynotes.domain.usecases.note.DeleteNoteUseCase
import com.mynotes.domain.usecases.note.GetNotesUseCase
import com.mynotes.domain.usecases.note.UpdateNoteUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCasesModule {

    @Provides
    fun provideICreateNoteUseCase(repository: INoteRepository): ICreateNoteUseCase {
        return CreateNoteUseCase(repository)
    }

    @Provides
    fun provideIDeleteNoteUseCase(repository: INoteRepository): IDeleteNoteUseCase {
        return DeleteNoteUseCase(repository)
    }

    @Provides
    fun provideGetNotesUseCase(repository: INoteRepository): IGetNotesUseCase {
        return GetNotesUseCase(repository)
    }

    @Provides
    fun provideIUpdateNoteUseCase(
        repository: INoteRepository,
        defaultDispatchers: ICoroutineDispatchers
    ): IUpdateNoteUseCase {
        return UpdateNoteUseCase(repository, defaultDispatchers)
    }
}

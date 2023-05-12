package com.mynotes.android.di.modules

import android.app.Application
import com.mynotes.core.contracts.dispatchers.CoroutineDispatchers
import com.mynotes.core.contracts.dispatchers.ICoroutineDispatchers
import com.mynotes.core.contracts.generators.INoteTitleGenerator
import com.mynotes.core.contracts.validators.INoteValidator
import com.mynotes.notes.validators.NoteValidator
import com.mynotes.resources.heplers.NoteTitleGenerator
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @Provides
    fun provideCoroutineDispatchers(): ICoroutineDispatchers {
        return CoroutineDispatchers()
    }

    @Provides
    fun provideNoteValidator(): INoteValidator {
        return NoteValidator()
    }

    @Provides
    fun provideNoteNoteTitleGenerator(application: Application): INoteTitleGenerator {
        return NoteTitleGenerator(application)
    }
}

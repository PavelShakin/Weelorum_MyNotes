package com.mynotes.android.di.modules

import androidx.lifecycle.ViewModel
import com.mynotes.android.screens.splash.SplashViewModel
import com.mynotes.core.views.ViewModelKey
import com.mynotes.notes.screens.noteDetails.NoteDetailsViewModel
import com.mynotes.notes.screens.notesList.MyNotesViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(SplashViewModel::class)
    fun bindSplashViewModel(viewModel: SplashViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(NoteDetailsViewModel::class)
    fun bindCreateNoteViewModel(viewModel: NoteDetailsViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MyNotesViewModel::class)
    fun bindMyNotesViewModel(viewModel: MyNotesViewModel): ViewModel
}

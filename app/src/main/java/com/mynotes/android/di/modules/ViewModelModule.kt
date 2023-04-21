package com.mynotes.android.di.modules

import androidx.lifecycle.ViewModel
import com.mynotes.android.screens.splash.SplashViewModel
import com.mynotes.core.views.ViewModelKey
import com.mynotes.notes.screens.createNote.CreateNoteViewModel
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
    @ViewModelKey(CreateNoteViewModel::class)
    fun bindCreateNoteViewModel(viewModel: CreateNoteViewModel): ViewModel
}

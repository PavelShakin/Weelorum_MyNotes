package com.mynotes.android.di.modules

import androidx.lifecycle.ViewModelProvider
import com.mynotes.core.views.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule {
    @Binds
    internal abstract fun bindViewModelFactory(
        factory: ViewModelFactory
    ): ViewModelProvider.Factory
}

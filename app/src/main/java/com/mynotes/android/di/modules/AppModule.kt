package com.mynotes.android.di.modules

import com.mynotes.core.contracts.dispatchers.CoroutineDispatchers
import com.mynotes.core.contracts.dispatchers.ICoroutineDispatchers
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @Provides
    fun provideCoroutineDispatchers(): ICoroutineDispatchers {
        return CoroutineDispatchers()
    }
}
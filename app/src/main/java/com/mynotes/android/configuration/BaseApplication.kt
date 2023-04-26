package com.mynotes.android.configuration

import com.mynotes.android.di.components.DaggerAppComponent
import com.mynotes.data.di.components.DaggerDataComponent
import com.mynotes.data.di.components.DataComponent
import com.mynotes.database.di.DaggerDatabaseComponent
import com.mynotes.database.di.DatabaseComponent
import com.mynotes.domain.di.components.DaggerDomainComponent
import com.mynotes.domain.di.components.DomainComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class BaseApplication : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent
            .builder()
            .application(this)
            .domainComponent(provideDomainComponent())
            .build()
    }

    private fun provideDomainComponent(): DomainComponent {
        return DaggerDomainComponent
            .builder()
            .application(this)
            .dataComponent(provideDataComponent())
            .build()
    }

    private fun provideDataComponent(): DataComponent {
        return DaggerDataComponent
            .builder()
            .application(this)
            .databaseComponent(provideDatabaseComponent())
            .build()
    }

    private fun provideDatabaseComponent(): DatabaseComponent {
        return DaggerDatabaseComponent
            .builder()
            .application(this)
            .build()
    }
}

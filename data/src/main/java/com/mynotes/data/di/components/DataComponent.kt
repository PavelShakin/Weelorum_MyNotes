package com.mynotes.data.di.components

import android.app.Application
import com.mynotes.data.di.annotations.DataScope
import com.mynotes.data.di.modules.RepositoryModule
import com.mynotes.database.di.DatabaseComponent
import com.mynotes.database.di.modules.DatabaseModule
import dagger.BindsInstance
import dagger.Component

@Component(
    modules = [
        DatabaseModule::class,
        RepositoryModule::class
    ]
)
@DataScope
interface DataComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        @BindsInstance
        fun databaseComponent(component: DatabaseComponent): Builder

        fun build(): DataComponent
    }
}

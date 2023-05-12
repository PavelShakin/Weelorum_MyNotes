package com.mynotes.database.di

import android.app.Application
import com.mynotes.database.di.modules.DatabaseModule
import com.mynotes.database.di.modules.LocalDataSourceModule
import dagger.BindsInstance
import dagger.Component

@Component(
    modules = [
        DatabaseModule::class,
        LocalDataSourceModule::class
    ]
)
@DatabaseScope
interface DatabaseComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): DatabaseComponent
    }
}

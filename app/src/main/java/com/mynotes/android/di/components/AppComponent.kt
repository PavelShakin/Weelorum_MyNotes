package com.mynotes.android.di.components

import android.app.Application
import androidx.annotation.NonNull
import com.mynotes.android.configuration.BaseApplication
import com.mynotes.android.di.annotation.ApplicationScope
import com.mynotes.android.di.modules.ActivityBuildersModule
import com.mynotes.android.di.modules.AppModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        AndroidSupportInjectionModule::class,
        AppModule::class,
        ActivityBuildersModule::class
    ]
)
@ApplicationScope
interface AppComponent : AndroidInjector<BaseApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(@NonNull application: Application): Builder
        fun build(): AppComponent
    }
}
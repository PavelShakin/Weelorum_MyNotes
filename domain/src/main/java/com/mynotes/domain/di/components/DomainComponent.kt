package com.mynotes.domain.di.components

import android.app.Application
import com.mynotes.data.di.components.DataComponent
import com.mynotes.domain.di.annotations.DomainScope
import com.mynotes.domain.di.modules.UseCasesModule
import dagger.BindsInstance
import dagger.Component

@Component(
    modules = [
        UseCasesModule::class
    ]
)
@DomainScope
interface DomainComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        @BindsInstance
        fun dataComponent(dataComponent: DataComponent): Builder

        fun build(): DomainComponent
    }
}

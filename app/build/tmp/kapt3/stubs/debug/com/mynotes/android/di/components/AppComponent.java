package com.mynotes.android.di.components;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/mynotes/android/di/components/AppComponent;", "Ldagger/android/AndroidInjector;", "Lcom/mynotes/android/configuration/BaseApplication;", "Builder", "app_debug"})
@com.mynotes.android.di.annotation.ApplicationScope()
@dagger.Component(modules = {dagger.android.AndroidInjectionModule.class, dagger.android.support.AndroidSupportInjectionModule.class, com.mynotes.android.di.modules.AppModule.class, com.mynotes.android.di.modules.ActivityBuildersModule.class, com.mynotes.android.di.modules.ViewModelFactoryModule.class, com.mynotes.android.di.modules.ViewModelModule.class, com.mynotes.android.di.modules.FragmentBuildersModule.class})
@javax.inject.Singleton()
public abstract interface AppComponent extends dagger.android.AndroidInjector<com.mynotes.android.configuration.BaseApplication> {
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00002\b\b\u0001\u0010\u0002\u001a\u00020\u0003H\'J\b\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/mynotes/android/di/components/AppComponent$Builder;", "", "application", "Landroid/app/Application;", "build", "Lcom/mynotes/android/di/components/AppComponent;", "app_debug"})
    @dagger.Component.Builder()
    public static abstract interface Builder {
        
        @org.jetbrains.annotations.NotNull()
        @dagger.BindsInstance()
        public abstract com.mynotes.android.di.components.AppComponent.Builder application(@org.jetbrains.annotations.NotNull()
        @androidx.annotation.NonNull()
        android.app.Application application);
        
        @org.jetbrains.annotations.NotNull()
        public abstract com.mynotes.android.di.components.AppComponent build();
    }
}
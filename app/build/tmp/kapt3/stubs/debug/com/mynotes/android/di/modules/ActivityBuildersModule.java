package com.mynotes.android.di.modules;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\'\u00a8\u0006\u0004"}, d2 = {"Lcom/mynotes/android/di/modules/ActivityBuildersModule;", "", "contributeMainActivity", "Lcom/mynotes/android/screens/base/MainActivity;", "app_debug"})
@dagger.Module()
public abstract interface ActivityBuildersModule {
    
    @org.jetbrains.annotations.NotNull()
    @dagger.android.ContributesAndroidInjector(modules = {com.mynotes.android.di.modules.ViewModelModule.class, com.mynotes.android.di.modules.FragmentBuildersModule.class, com.mynotes.android.di.modules.ViewModelFactoryModule.class})
    public abstract com.mynotes.android.screens.base.MainActivity contributeMainActivity();
}
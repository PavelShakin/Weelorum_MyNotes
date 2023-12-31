package com.mynotes.android.di.modules

import com.mynotes.android.screens.splash.SplashFragment
import com.mynotes.core.views.BaseFragment
import com.mynotes.notes.screens.noteDetails.NoteDetailsFragment
import com.mynotes.notes.screens.notesList.MyNotesFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface FragmentBuildersModule {

    //region Application
    @ContributesAndroidInjector
    fun contributeBaseFragment(): BaseFragment

    @ContributesAndroidInjector
    fun contributeSplashFragment(): SplashFragment
    //endregion

    //region Notes
    @ContributesAndroidInjector
    fun contributeNotesListFragment(): MyNotesFragment

    @ContributesAndroidInjector
    fun contributeCreateNoteFragment(): NoteDetailsFragment
}

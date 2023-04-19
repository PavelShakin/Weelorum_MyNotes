package com.mynotes.android.screens.splash

sealed class SplashViewState {
    data class IsLoadingState(val isLoading: Boolean = true) : SplashViewState()
    data class IsNotesEmptyState(private val isNotesEmpty: Boolean = false) : SplashViewState() {
        fun isNotesEmpty(): Boolean = isNotesEmpty
    }
}

sealed class SplashAction {
    object OnCreateNoteScreen : SplashAction()
    object OnNotesListScreen : SplashAction()
}

sealed class SplashEvent {
    object Load : SplashEvent()
    object OnNext : SplashEvent()
}

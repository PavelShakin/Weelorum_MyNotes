package com.mynotes.android.screens.splash

sealed class SplashViewState {
    data class State(val isLoading: Boolean = true) : SplashViewState()
}

sealed class SplashAction {
    object OnCreateNoteScreen : SplashAction()
    object OnMyNotesScreen : SplashAction()
}

sealed class SplashEvent {
    object Load : SplashEvent()
}

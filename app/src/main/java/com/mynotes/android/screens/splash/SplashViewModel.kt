package com.mynotes.android.screens.splash

import androidx.lifecycle.viewModelScope
import com.mynotes.core.contracts.dispatchers.ICoroutineDispatchers
import com.mynotes.core.contracts.handlers.EventHandler
import com.mynotes.core.views.BaseViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SplashViewModel @Inject constructor(
    private val defaultDispatcher: ICoroutineDispatchers
) : BaseViewModel<SplashViewState, SplashAction>(),
    EventHandler<SplashEvent> {

    companion object {
        private const val DEFAULT_DELAY = 2000L
    }

    init {
        viewState = SplashViewState.IsLoadingState()
    }

    private fun checkIsNotesEmpty() {
        viewModelScope.launch {
            withContext(defaultDispatcher.io) {
                delay(DEFAULT_DELAY)
                viewState = SplashViewState.IsNotesEmptyState(true)
                obtainEvent(SplashEvent.OnNext)
            }
        }
    }

    override fun obtainEvent(event: SplashEvent) {
        when (val state = viewState) {
            is SplashViewState.IsNotesEmptyState -> reduce(event, state)
            is SplashViewState.IsLoadingState -> reduce(event, state)
        }
    }

    private fun reduce(event: SplashEvent, state: SplashViewState.IsLoadingState) {
        when (event) {
            is SplashEvent.Load -> checkIsNotesEmpty()
            else -> throw IllegalArgumentException("event: $event with state $state")
        }
    }

    private fun reduce(event: SplashEvent, state: SplashViewState.IsNotesEmptyState) {
        when (event) {
            is SplashEvent.Load -> onNextScreen(state)
            is SplashEvent.OnNext -> onNextScreen(state)
        }
    }

    private fun onNextScreen(state: SplashViewState.IsNotesEmptyState) {
        viewModelScope.launch {
            viewAction = if (state.isNotesEmpty()) {
                SplashAction.OnCreateNoteScreen
            } else {
                SplashAction.OnNotesListScreen
            }
        }
    }
}

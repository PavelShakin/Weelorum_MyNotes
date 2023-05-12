package com.mynotes.android.screens.splash

import androidx.lifecycle.viewModelScope
import com.mynotes.core.contracts.dispatchers.ICoroutineDispatchers
import com.mynotes.core.contracts.handlers.EventHandler
import com.mynotes.core.usecases.note.IGetNotesUseCase
import com.mynotes.core.views.BaseViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SplashViewModel @Inject constructor(
    private val defaultDispatcher: ICoroutineDispatchers,
    private val getNotesUseCase: IGetNotesUseCase
) : BaseViewModel<SplashViewState, SplashAction>(),
    EventHandler<SplashEvent> {

    companion object {
        private const val DEFAULT_DELAY = 2000L
    }

    init {
        viewState = SplashViewState.State(true)
    }

    override fun obtainEvent(event: SplashEvent) {
        when (event) {
            is SplashEvent.Load -> checkIsNotesEmpty()
        }
    }

    private fun checkIsNotesEmpty() {
        viewModelScope.launch {
            withContext(defaultDispatcher.io) {
                delay(DEFAULT_DELAY)
                viewAction = if (getNotesUseCase.invoke().isEmpty()) {
                    SplashAction.OnCreateNoteScreen
                } else {
                    SplashAction.OnMyNotesScreen
                }
            }
        }
    }
}

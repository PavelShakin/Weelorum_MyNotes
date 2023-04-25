package com.mynotes.notes.screens.createNote

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.text.input.TextFieldValue
import com.mynotes.core.views.BaseFragment
import com.mynotes.core.views.utils.injectViewModel
import com.mynotes.notes.R
import com.mynotes.resources.components.EditNoteComponent
import com.mynotes.resources.themes.AppTheme

class CreateNoteFragment : BaseFragment() {

    private val viewModel: CreateNoteViewModel by lazy {
        injectViewModel(factory = providerFactory)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        requireActivity().onBackPressedDispatcher.addCallback(this) {
            viewModel.obtainEvent(CreateNoteEvent.OnBackPressed)
        }
        subscriptions()
        return ComposeView(requireContext())
            .apply {
                setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
                viewModel.viewStates().observe(viewLifecycleOwner) { state ->
                    when (state) {
                        is CreateNoteViewState.State -> {
                            setContent {
                                AppTheme {
                                    var title by remember { mutableStateOf(TextFieldValue(text = "")) }
                                    var note by remember { mutableStateOf(TextFieldValue(text = "")) }
                                    EditNoteComponent(
                                        titleValue = title,
                                        onTitleValueChange = {
                                            title = it
                                            viewModel.obtainEvent(CreateNoteEvent.UpdateTitle(it.text))
                                        },
                                        noteValue = note,
                                        onNoteValueChange = {
                                            note = it
                                            viewModel.obtainEvent(CreateNoteEvent.UpdateNote(it.text))
                                        },
                                        buttonEnabled = state.buttonEnabled,
                                        onSaveClick = {
                                            viewModel.obtainEvent(CreateNoteEvent.Save)
                                        },
                                        isAlertShowing = state.isAlertShowing,
                                        onNavigateToNotesScreenClick = {
                                            viewModel.obtainEvent(CreateNoteEvent.NavigateToNotesScreen)
                                        },
                                        onContinueClick = {
                                            viewModel.obtainEvent(CreateNoteEvent.Continue)
                                        }
                                    )
                                }
                            }
                        }
                    }
                }
            }
    }

    private fun subscriptions() {
        viewModel.viewActions().observe(viewLifecycleOwner) { action ->
            when (action) {
                is CreateNoteAction.NextPage -> {
                    navigateToAction(R.id.action_createNoteFragment_to_myNotesFragment)
                }
            }
        }
    }
}

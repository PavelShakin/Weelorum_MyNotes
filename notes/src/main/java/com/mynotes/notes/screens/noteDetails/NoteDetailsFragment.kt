package com.mynotes.notes.screens.noteDetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.compose.material.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import com.mynotes.core.common.GlobalConstants
import com.mynotes.core.common.GlobalConstants.emptyString
import com.mynotes.core.views.BaseFragment
import com.mynotes.core.views.utils.injectViewModel
import com.mynotes.resources.R
import com.mynotes.resources.components.EditNoteComponent
import com.mynotes.resources.themes.AppTheme
import com.mynotes.resources.widgets.HeaderWidgets.TopHeaderWithDeleteButton
import com.mynotes.notes.R as cR

class NoteDetailsFragment : BaseFragment() {

    private val viewModel: NoteDetailsViewModel by lazy {
        injectViewModel(factory = providerFactory)
    }

    private val lifecycleOwner = this

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        subscriptions()
        return ComposeView(requireContext())
            .apply {
                setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
                viewModel.viewStates().observe(viewLifecycleOwner) { state ->
                    when (state) {
                        is NoteDetailsViewState.State -> {
                            requireActivity().onBackPressedDispatcher.addCallback(lifecycleOwner) {
                                if (state.description.isEmpty()) {
                                    viewModel.obtainEvent(NoteDetailsEvent.OnBackPressed)
                                } else {
                                    goBack()
                                }
                            }
                            setContent {
                                AppTheme {
                                    var title by remember { mutableStateOf(TextFieldValue(text = emptyString)) }
                                    var description by remember { mutableStateOf(TextFieldValue(text = emptyString)) }
                                    Scaffold(
                                        topBar = {
                                            TopHeaderWithDeleteButton(
                                                title = stringResource(id = R.string.header_note_details),
                                                isDeleteButtonVisible = state.noteId.isNotEmpty(),
                                                onDeleteClick = {
                                                    viewModel.obtainEvent(NoteDetailsEvent.ShowDeleteDialog)
                                                }
                                            )
                                        }
                                    ) { padding ->
                                        padding.calculateBottomPadding()
                                        EditNoteComponent(
                                            titleValue = title.copy(text = state.title),
                                            onTitleValueChange = {
                                                title = it
                                                viewModel.obtainEvent(
                                                    NoteDetailsEvent.UpdateTitle(
                                                        it.text
                                                    )
                                                )
                                            },
                                            noteValue = description.copy(text = state.description),
                                            onNoteValueChange = {
                                                description = it
                                                viewModel.obtainEvent(
                                                    NoteDetailsEvent.UpdateNoteDetails(
                                                        it.text
                                                    )
                                                )
                                            },
                                            buttonEnabled = state.buttonEnabled(),
                                            onSaveClick = {
                                                viewModel.obtainEvent(NoteDetailsEvent.Save)
                                            },
                                            isGoBackDialogShowing = state.isGoBackDialogShowing,
                                            isDeleteDialogShowing = state.isDeleteDialogShowing,
                                            onNavigateToNotesScreenClick = {
                                                viewModel.obtainEvent(NoteDetailsEvent.NavigateToNotesScreen)
                                            },
                                            onDeleteNoteClick = {
                                                viewModel.obtainEvent(NoteDetailsEvent.DeleteNote)
                                            },
                                            onCancelDialogClick = {
                                                viewModel.obtainEvent(NoteDetailsEvent.CancelDialog)
                                            },
                                            isError = state.noteError == null,
                                            errorText = state.noteError
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setEditMode()
    }

    private fun setEditMode() {
        val noteId = arguments?.getString(GlobalConstants.BundleKey.NOTE_ID) ?: emptyString
        viewModel.obtainEvent(NoteDetailsEvent.Load(noteId))
    }

    private fun subscriptions() {
        viewModel.viewActions().observe(viewLifecycleOwner) { action ->
            when (action) {
                is NoteDetailsAction.Success -> {
                    navigateToAction(cR.id.action_createNoteFragment_to_myNotesFragment)
                }
            }
        }
    }
}

package com.mynotes.notes.screens.notesList

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.addCallback
import androidx.compose.material.Scaffold
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.res.stringResource
import androidx.core.os.bundleOf
import com.mynotes.core.common.GlobalConstants
import com.mynotes.core.common.GlobalConstants.backPressDelay
import com.mynotes.core.views.BaseFragment
import com.mynotes.core.views.utils.injectViewModel
import com.mynotes.resources.R
import com.mynotes.resources.components.NotesListComponent
import com.mynotes.resources.themes.AppTheme
import com.mynotes.resources.widgets.HeaderWidgets.DefaultTopHeader
import com.mynotes.resources.widgets.HeaderWidgets.TopHeaderWithDeleteAndCancelButton
import com.mynotes.notes.R as cR

class MyNotesFragment : BaseFragment() {

    private val viewModel: MyNotesViewModel by lazy {
        injectViewModel(
            factory = providerFactory
        )
    }

    private var backPressedTime: Long = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        subscriptions()
        return ComposeView(requireContext())
            .apply {
                setViewCompositionStrategy(
                    ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed
                )
                viewModel.viewStates().observe(viewLifecycleOwner) { state ->
                    if (state is MyNotesViewState.State) {
                        setContent {
                            AppTheme {
                                Scaffold(
                                    topBar = {
                                        if (state.isSelectMultipleMode) {
                                            TopHeaderWithDeleteAndCancelButton(
                                                title = stringResource(id = R.string.header_note_delete_selected),
                                                onDeleteClick = {
                                                    viewModel.obtainEvent(MyNotesEvent.DeleteSelectedNotes)
                                                },
                                                onCancelClick = {
                                                    viewModel.obtainEvent(MyNotesEvent.CancelSelection)
                                                }
                                            )
                                        } else {
                                            DefaultTopHeader(
                                                title = stringResource(id = R.string.header_notes_list)
                                            )
                                        }
                                    }
                                ) { padding ->
                                    padding.calculateBottomPadding()
                                    NotesListComponent(
                                        notes = state.notes,
                                        selectedNotes = state.selectedNotes,
                                        onNoteClick = {
                                            if (state.isSelectMultipleMode) {
                                                viewModel.obtainEvent(MyNotesEvent.OnNoteSelect(it))
                                            } else {
                                                viewModel.obtainEvent(MyNotesEvent.OnNoteClick(it))
                                            }
                                        },
                                        onNoteLongClick = {
                                            viewModel.obtainEvent(MyNotesEvent.OnNoteSelect(it))
                                        },
                                        onCreateNoteClick = {
                                            viewModel.obtainEvent(MyNotesEvent.CreateNote)
                                        }
                                    )
                                }
                            }
                        }
                    }
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.obtainEvent(MyNotesEvent.Load)
    }

    private fun subscriptions() {
        quitAppOnDoubleBackPressed()
        viewModel.viewActions().observe(viewLifecycleOwner) { action ->
            when (action) {
                is MyNotesAction.GoToNoteDetails -> {
                    if (action.note != null) {
                        val bundle = bundleOf(
                            GlobalConstants.BundleKey.NOTE_ID to action.note.id
                        )
                        navigateToAction(
                            cR.id.action_myNotesFragment_to_editNoteFragment,
                            bundle
                        )
                    } else {
                        navigateToAction(
                            cR.id.action_myNotesFragment_to_editNoteFragment
                        )
                    }
                }
            }
        }
    }

    private fun quitAppOnDoubleBackPressed() {
        requireActivity().onBackPressedDispatcher.addCallback(this) {
            if (backPressedTime + backPressDelay >= System.currentTimeMillis()) {
                requireActivity().finish()
            } else {
                Toast.makeText(context, getString(R.string.press_back_to_leave), Toast.LENGTH_SHORT)
                    .show()
            }
            backPressedTime = System.currentTimeMillis()
        }
    }
}

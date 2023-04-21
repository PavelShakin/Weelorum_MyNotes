package com.mynotes.notes.screens.createNote

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.text.input.TextFieldValue
import com.mynotes.core.views.BaseFragment
import com.mynotes.core.views.utils.injectViewModel
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
        return ComposeView(requireContext())
            .apply {
                setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
                viewModel.viewStates().observe(viewLifecycleOwner) { state ->
                    when (state) {
                        is CreateNoteViewState.State -> {
                            setContent {
                                AppTheme {
                                    val title by remember { mutableStateOf(TextFieldValue(text = state.title)) }
                                    val note by remember { mutableStateOf(TextFieldValue(text = state.note)) }
                                    EditNoteComponent(
                                        titleValue = title,
                                        onTitleValueChange = {},
                                        noteValue = note,
                                        onNoteValueChange = {},
                                        buttonEnabled = false,
                                        onBackClick = {},
                                        onSaveClick = {}
                                    )
                                }
                            }
                        }
                    }
                }
            }
    }
}

package com.mynotes.notes.screens.notes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.addCallback
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import com.mynotes.core.common.GlobalConstraints.backPressDelay
import com.mynotes.core.views.BaseFragment
import com.mynotes.resources.R
import com.mynotes.resources.components.NotesListComponent
import com.mynotes.resources.themes.AppTheme

class MyNotesFragment : BaseFragment() {

    private var backPressedTime: Long = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        requireActivity().onBackPressedDispatcher.addCallback(this) {
            if (backPressedTime + backPressDelay >= System.currentTimeMillis()) {
                requireActivity().finish()
            } else {
                Toast.makeText(context, getString(R.string.press_back_to_leave), Toast.LENGTH_SHORT).show()
            }
            backPressedTime = System.currentTimeMillis()
        }
        return ComposeView(requireContext())
            .apply {
                setViewCompositionStrategy(
                    ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed
                )
                setContent {
                    AppTheme {
                        NotesListComponent(
                            onNoteClick = {}
                        )
                    }
                }
            }
    }
}

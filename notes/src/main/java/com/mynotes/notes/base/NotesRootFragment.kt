package com.mynotes.notes.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mynotes.core.views.BaseFragment
import com.mynotes.notes.databinding.FragmentNotesRootBinding

class NotesRootFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentNotesRootBinding.inflate(inflater, container, false)
        return binding.root
    }
}
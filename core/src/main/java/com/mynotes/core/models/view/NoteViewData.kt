package com.mynotes.core.models.view

import com.mynotes.core.common.GlobalConstraints.emptyString

data class NoteViewData(
    val id: String = emptyString,
    val title: String = emptyString,
    val note: String = emptyString
)

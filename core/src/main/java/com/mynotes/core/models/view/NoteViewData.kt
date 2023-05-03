package com.mynotes.core.models.view

import com.mynotes.core.common.GlobalConstants.emptyString

data class NoteViewData(
    val id: String = emptyString,
    val title: String = emptyString,
    val description: String = emptyString
)

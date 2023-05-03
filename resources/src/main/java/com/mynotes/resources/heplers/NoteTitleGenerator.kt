package com.mynotes.resources.heplers

import android.app.Application
import com.mynotes.core.common.GlobalConstants
import com.mynotes.core.contracts.generators.INoteTitleGenerator
import com.mynotes.resources.R
import java.lang.StringBuilder
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle
import javax.inject.Inject

class NoteTitleGenerator @Inject constructor(
    private val application: Application
) : INoteTitleGenerator {
    override fun generateNoteTitle(): String {
        val current = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)
        val currentTimeAndDate = current.format(formatter)
        return StringBuilder()
            .append(application.getString(R.string.note_empty_title))
            .append(GlobalConstants.space)
            .append(currentTimeAndDate)
            .toString()
    }
}

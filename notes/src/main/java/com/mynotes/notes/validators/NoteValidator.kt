package com.mynotes.notes.validators

import com.mynotes.core.contracts.validators.INoteValidator
import com.mynotes.resources.R

class NoteValidator : INoteValidator {

    override fun fieldIsNotEmpty(input: String): Int? {
        if (input.isEmpty()) return R.string.error_input_is_empty
        return defaultReturnValue
    }

    override fun noteIsValid(note: String): Int? {
        return when {
            note.isEmpty() -> R.string.error_input_is_empty_2
            else -> defaultReturnValue
        }
    }
}

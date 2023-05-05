package com.mynotes.core.contracts.validators

interface INoteValidator : BaseTextFieldValidator {

    fun noteIsValid(note: String): Int?
}

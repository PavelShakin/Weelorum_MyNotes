package com.mynotes.core.contracts.validators

interface BaseTextFieldValidator {

    val defaultReturnValue: Int?
        get() = null

    fun fieldIsNotEmpty(input: String): Int?
}

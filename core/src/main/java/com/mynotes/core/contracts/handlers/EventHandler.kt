package com.mynotes.core.contracts.handlers

interface EventHandler<T> {
    fun obtainEvent(event: T)
}

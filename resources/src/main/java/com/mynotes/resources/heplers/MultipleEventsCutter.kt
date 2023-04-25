package com.mynotes.resources.heplers

import com.mynotes.core.common.GlobalConstraints.defaultDelay

internal interface MultipleEventsCutter {

    fun processEvent(event: () -> Unit)

    companion object
}

internal fun MultipleEventsCutter.Companion.get(): MultipleEventsCutter = MultipleEventsCutterImpl()

private class MultipleEventsCutterImpl : MultipleEventsCutter {

    private val now: Long
        get() = System.currentTimeMillis()
    private var lastEventTimeMs: Long = 0

    override fun processEvent(event: () -> Unit) {
        if (now - lastEventTimeMs >= defaultDelay) {
            event.invoke()
        }
        lastEventTimeMs = now
    }
}

package com.mynotes.core.contracts.dispatchers

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

interface ICoroutineDispatchers {
    val ui: CoroutineDispatcher
    val io: CoroutineDispatcher
}

class CoroutineDispatchers @Inject constructor() : ICoroutineDispatchers {
    override val ui: CoroutineDispatcher = Dispatchers.Main
    override val io: CoroutineDispatcher = Dispatchers.IO
}

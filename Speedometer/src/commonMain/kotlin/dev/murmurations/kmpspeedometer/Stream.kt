package dev.murmurations.kmpspeedometer

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow


interface Stream<T>  {
    val flow: Flow<T>
}

interface SharedStream<T> : Stream<T> {
    override val flow: SharedFlow<T>
}

interface StateStream<T> : SharedStream<T> {
    override val flow: StateFlow<T>
}

abstract class MutableStateStream<T>(
    val initialState: T
) : StateStream<T> {
    override val flow = MutableStateFlow<T>(initialState)
    fun setState(value: T) { flow.value = value }
}

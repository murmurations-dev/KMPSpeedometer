package dev.murmurations.kmpspeedometer

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow


interface Stream_I<T>  {
    val flow: Flow<T>
}

interface SharedStream_I<T> : Stream_I<T> {
    override val flow: SharedFlow<T>
}

interface StateStream<T> : SharedStream_I<T> {
    override val flow: StateFlow<T>
}

interface MutableStateStream_I<T> : StateStream<T> {
    override val flow: MutableStateFlow<T>
    fun setState(value: T)
}

abstract class MutableStateStream_A<T>(
    val initialState: T
) : MutableStateStream_I<T> {
    override val flow = MutableStateFlow<T>(initialState)
    override fun setState(value: T) { flow.value = value }
}

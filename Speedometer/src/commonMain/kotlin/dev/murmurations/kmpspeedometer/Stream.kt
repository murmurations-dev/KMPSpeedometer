package dev.murmurations.kmpspeedometer

import com.rickclephas.kmp.nativecoroutines.NativeCoroutines
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
    val setState: (T) -> Unit
}

open class MutableStateStream<T>(
    val initialState: T
) : MutableStateStream_I<T> {
    override val flow = MutableStateFlow<T>(initialState)
    override val setState: (T) -> Unit = { flow.value = it }
}

interface MutableStateSeed<T> {
    val sharedMutableStateFlow: MutableStateFlow<T>
//    val flow: MutableStateFlow<T> // by lazy { MutableStateFlow<T>(initialState) }
//        get() = MutableStateFlow<T>(initialState)
    val setState: (T) -> Unit
        get() = { sharedMutableStateFlow.value = it }
}

interface RunningStateSeed : MutableStateSeed<RunningState> {
    override val sharedMutableStateFlow: MutableStateFlow<RunningState>
    val start: () -> Unit
        get() = { setState(RunningState.Started) }
    val stop: () -> Unit
        get() = { setState(RunningState.Stopped) }

    @OptIn(kotlin.experimental.ExperimentalObjCName::class)
    @NativeCoroutines
    val runningFlow: MutableStateFlow<RunningState>
        get() = sharedMutableStateFlow
}

interface RunningStateSeed2 : MutableStateSeed<RunningSeed> {
    override val sharedMutableStateFlow: MutableStateFlow<RunningSeed>
    val start: () -> Unit
        get() = { setState(object : RunningSeed.Started{}) }
    val stop: () -> Unit
        get() = { setState(object : RunningSeed.Stopped{}) }

    @OptIn(kotlin.experimental.ExperimentalObjCName::class)
    @NativeCoroutines
    val runningFlow: MutableStateFlow<RunningSeed>
        get() = sharedMutableStateFlow
}
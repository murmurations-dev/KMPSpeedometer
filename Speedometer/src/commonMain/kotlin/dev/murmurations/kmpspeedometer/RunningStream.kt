package dev.murmurations.kmpspeedometer

import com.rickclephas.kmp.nativecoroutines.NativeCoroutines

//interface RunningStream_I : MutableStateStream_I<RunningState> {
//    fun start()
//    fun stop()
//}

open class RunningStream(
    initialState: RunningState
) : MutableStateStream<RunningState>(initialState)  {
    fun start() = setState(RunningState.Started)
    fun stop() = setState(RunningState.Stopped)

    @OptIn(kotlin.experimental.ExperimentalObjCName::class)
    @NativeCoroutines
    val runningFlow = super.flow
}

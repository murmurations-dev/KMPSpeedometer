package dev.murmurations.kmpspeedometer

import com.rickclephas.kmp.nativecoroutines.NativeCoroutines

abstract class RunningStream(
    initialState: RunningState
) : RunningStream_A(initialState) {
    @OptIn(kotlin.experimental.ExperimentalObjCName::class)
    @NativeCoroutines
    val runningFlow = super.flow
}
package dev.murmurations.kmpspeedometer

import com.rickclephas.kmp.nativecoroutines.NativeCoroutines

abstract class RunningStream_T(
    initialState: RunningState
) : RunningStream_A(initialState) {
    @OptIn(kotlin.experimental.ExperimentalObjCName::class)
    @NativeCoroutines
    val runningFlow = super.flow
}
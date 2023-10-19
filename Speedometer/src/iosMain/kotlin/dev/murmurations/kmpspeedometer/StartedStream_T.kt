package dev.murmurations.kmpspeedometer

import com.rickclephas.kmp.nativecoroutines.NativeCoroutines

abstract class StartedStream_T(
    initialState: StartedState
) : StartedStream_A(initialState) {
    @OptIn(kotlin.experimental.ExperimentalObjCName::class)
    @NativeCoroutines
    val startedFlow = super.flow
}
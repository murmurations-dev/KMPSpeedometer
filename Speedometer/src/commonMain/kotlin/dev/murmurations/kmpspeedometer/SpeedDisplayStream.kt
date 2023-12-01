package dev.murmurations.kmpspeedometer

import com.rickclephas.kmp.nativecoroutines.NativeCoroutines
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map

abstract class SpeedDisplayStream_A<L>(
    val runningStream: RunningStream,
    val speedEvaluationStream: SpeedEvaluationStream_I<L>,
    val speedUnitStream: SpeedUnitStream
) {
    abstract fun format(number: Float): String

    @OptIn(kotlin.experimental.ExperimentalObjCName::class)
    @NativeCoroutines
    val unitDisplayFlow: Flow<String>
        get() = speedUnitStream.flow.map { it.userDisplay }

    @OptIn(ExperimentalCoroutinesApi::class, kotlin.experimental.ExperimentalObjCName::class)
    @NativeCoroutines
    val speedDisplayFlow: Flow<String>
        get() = runningStream.flow.flatMapLatest { runningState ->
            when (runningState) {
                is RunningState.Stopped -> flowOf("--")
                is RunningState.Started -> combine(
                    speedEvaluationStream.flow,
                    speedUnitStream.flow
                ) { speed, unit ->
                    format(unit.transform(speed))
                }
            }
        }

    @OptIn(kotlin.experimental.ExperimentalObjCName::class)
    @NativeCoroutines
    val runningStateFlow = runningStream.flow

    val start = runningStream.start
    val stop = runningStream.stop
}
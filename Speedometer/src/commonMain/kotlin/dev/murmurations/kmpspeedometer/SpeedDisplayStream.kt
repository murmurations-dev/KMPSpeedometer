package dev.murmurations.kmpspeedometer

import com.rickclephas.kmp.nativecoroutines.NativeCoroutines
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map

abstract class SpeedDisplayStream_A<L,R,T:SpeedUnit_I<R>>(
    val runningStream: RunningStream_I,
    val speedEvaluationStream: SpeedEvaluationStream_I<L,R>,
    val speedUnitStream: MutableStateStream_I<T>
) {
    abstract fun format(number: R): String

    @OptIn(kotlin.experimental.ExperimentalObjCName::class)
    @NativeCoroutines
    val unitDisplayFlow: Flow<String>
        get() = speedUnitStream.flow.map { it.userDisplay }

    private val valueDisplayFlow: Flow<String>
        get() = combine(
            speedEvaluationStream.flow,
            speedUnitStream.flow
        ) { speed, unit ->
            format(unit.transform(speed))
        }

    @OptIn(ExperimentalCoroutinesApi::class, kotlin.experimental.ExperimentalObjCName::class)
    @NativeCoroutines
    val speedDisplayflow: Flow<String>
        get() = runningStream.flow.flatMapLatest { runningState ->
            when (runningState) {
                is RunningState.Stopped -> flowOf("--")
                is RunningState.Started -> valueDisplayFlow
            }
        }
}
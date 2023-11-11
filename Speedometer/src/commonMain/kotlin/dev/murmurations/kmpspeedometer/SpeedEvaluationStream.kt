package dev.murmurations.kmpspeedometer

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.mapNotNull
import kotlinx.coroutines.flow.shareIn
import kotlin.coroutines.EmptyCoroutineContext

data class LocationDifference<R>(
    val dx: R,
    val dt: R
)

interface SpeedCalculation_I<L,R> {
    fun diff(locations: Pair<L,L>): LocationDifference<R>
    fun divide(differences: LocationDifference<R>): R?
}

interface SpeedEvaluationStream_I<L,R> : SharedStream_I<R> {
    val locationUpdateStream: LocationUpdateStream_I<L>
}

abstract class SpeedEvaluationStream_A<L,R> : SpeedEvaluationStream_I<L,R>, SpeedCalculation_I<L,R> {
    private val sharingScope = CoroutineScope(EmptyCoroutineContext)

    override val flow
        get() = locationUpdateStream.flow
            .runningPair()
            .map(::diff)
            .mapNotNull(::divide)
            .shareIn(sharingScope, SharingStarted.WhileSubscribed())
}
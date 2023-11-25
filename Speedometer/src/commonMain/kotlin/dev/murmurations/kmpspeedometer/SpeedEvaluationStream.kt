package dev.murmurations.kmpspeedometer

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.mapNotNull
import kotlinx.coroutines.flow.shareIn
import kotlin.coroutines.EmptyCoroutineContext

data class LocationDifference(
    val dx: Float,
    val dt: Float
)

interface SpeedCalculation_I<L> {
    fun diff(locations: Pair<L,L>): LocationDifference
    fun divide(differences: LocationDifference): Float?
}

interface SpeedEvaluationStream_I<L> : SharedStream_I {
    val locationUpdateStream: LocationUpdateStream_I<L>
}

abstract class SpeedEvaluationStream_A<L> : SpeedEvaluationStream_I<L>, SpeedCalculation_I<L> {
    private val sharingScope = CoroutineScope(EmptyCoroutineContext)

    override val flow
        get() = locationUpdateStream.flow
            .runningPair()
            .map(::diff)
            .mapNotNull(::divide)
            .shareIn(sharingScope, SharingStarted.WhileSubscribed())
}
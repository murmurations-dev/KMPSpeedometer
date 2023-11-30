package dev.murmurations.kmpspeedometer

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
    fun difference(locations: Pair<L,L>): LocationDifference
}

interface SpeedEvaluationStream_I<L> : SharedStream_I<Float> {
    val locationUpdateStream: LocationUpdateStream_I<L>
}

abstract class SpeedEvaluationStream_A<L> : SpeedEvaluationStream_I<L>, SpeedCalculation_I<L> {
    private val sharingScope = CoroutineScope(EmptyCoroutineContext)

    private fun speed(difference: LocationDifference): Float? {
        val (dx, dt) = difference
        return when {
            (dt > 0.0) -> dx/dt
            else -> null
        }
    }

    override val flow
        get() = locationUpdateStream.flow
            .runningPair()
            .map(::difference)
            .mapNotNull(::speed)
            .shareIn(sharingScope, SharingStarted.WhileSubscribed())
}
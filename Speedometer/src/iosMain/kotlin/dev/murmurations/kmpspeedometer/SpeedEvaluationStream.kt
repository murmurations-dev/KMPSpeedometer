package dev.murmurations.kmpspeedometer

import com.rickclephas.kmp.nativecoroutines.NativeCoroutines
import platform.CoreLocation.CLLocation
import platform.Foundation.timeIntervalSinceDate

class SpeedEvaluationStream(
    override val locationUpdateStream: LocationUpdateStream_I<CLLocation>
) : SpeedEvaluationStream_A<CLLocation,Double>() {

    override fun diff(locations: Pair<CLLocation, CLLocation>): LocationDifference<Double> {
        val (l0, l1) = locations
        val t0 = l0.timestamp
        val t1 = l1.timestamp
        return LocationDifference(
            dx = l1.distanceFromLocation(l0),
            dt = t1.timeIntervalSinceDate(t0)
        )
    }

    override fun divide(differences: LocationDifference<Double>): Double? {
        val (dx, dt) = differences
        if (dt <= 0.0) return null
        return dx/dt
    }

    //*** Progress
    @OptIn(kotlin.experimental.ExperimentalObjCName::class)
    @NativeCoroutines
    val speedEvaluationFlow = super.flow
}
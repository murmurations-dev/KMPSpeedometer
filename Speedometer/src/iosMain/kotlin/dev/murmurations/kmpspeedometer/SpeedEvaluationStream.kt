package dev.murmurations.kmpspeedometer

import com.rickclephas.kmp.nativecoroutines.NativeCoroutines
import platform.CoreLocation.CLLocation
import platform.Foundation.timeIntervalSinceDate

class SpeedEvaluationStream(
    override val locationUpdateStream: LocationUpdateStream_I<CLLocation>
) : SpeedEvaluationStream_A<CLLocation>() {

    override fun difference(locations: Pair<CLLocation, CLLocation>): LocationDifference {
        val (l0, l1) = locations
        val t0 = l0.timestamp
        val t1 = l1.timestamp
        return LocationDifference(
            dx = l1.distanceFromLocation(l0).toFloat(),
            dt = t1.timeIntervalSinceDate(t0).toFloat()
        )
    }

    //*** Progress
    @OptIn(kotlin.experimental.ExperimentalObjCName::class)
    @NativeCoroutines
    val speedEvaluationFlow = super.flow
}
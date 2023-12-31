package dev.murmurations.kmpspeedometer

import android.location.Location

class SpeedEvaluationStream(
    override val locationUpdateStream: LocationUpdateStream_I<Location>
) : SpeedEvaluationStream_A<Location>() {

    override fun difference(locations: Pair<Location,Location>): LocationDifference {
        String.format("%.2f", 1.0F)

        val (l0, l1) = locations
        val t0 = l0.time
        val t1 = l1.time
        return LocationDifference(
            dx = l1.distanceTo(l0),
            dt = (t1 - t0).toFloat()/1e3f
        )
    }
}
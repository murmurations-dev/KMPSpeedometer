package dev.murmurations.kmpspeedometer

import android.location.Location

class SpeedDisplayStream(
    runningStream: RunningStream,
    speedEvaluationStream: SpeedEvaluationStream_I<Location>,
    speedUnitStream: SpeedUnitStream,
    val displayFormat: String
) : SpeedDisplayStream_A<Location>(
    runningStream,
    speedEvaluationStream,
    speedUnitStream
) {
    override fun format(number: Float): String = String.format(displayFormat, number)
}
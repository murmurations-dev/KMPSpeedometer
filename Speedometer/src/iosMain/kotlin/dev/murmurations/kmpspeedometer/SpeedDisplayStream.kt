package dev.murmurations.kmpspeedometer

import platform.CoreLocation.CLLocation
import platform.Foundation.NSString
import platform.Foundation.stringWithFormat

open class SpeedDisplayStream(
    runningStream: RunningStream,
    speedEvaluationStream: SpeedEvaluationStream_I<CLLocation>,
    speedUnitStream: SpeedUnitStream,
    val displayFormat: String
) : SpeedDisplayStream_A<CLLocation>(
        runningStream,
        speedEvaluationStream,
        speedUnitStream
) {
    override fun format(number: Float): String = NSString.stringWithFormat(displayFormat, number)
}
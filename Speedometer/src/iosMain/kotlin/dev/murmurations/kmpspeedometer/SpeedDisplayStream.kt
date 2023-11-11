package dev.murmurations.kmpspeedometer

import com.rickclephas.kmp.nativecoroutines.NativeCoroutines
import platform.CoreLocation.CLLocation
import platform.Foundation.NSString
import platform.Foundation.stringWithFormat

class SpeedDisplayStream(
    runningStream: RunningStream_I,
    speedEvaluationStream: SpeedEvaluationStream_I<CLLocation,Double>,
    speedUnitStream: MutableStateStream_I<SpeedUnit_I<Double>>
) : SpeedDisplayStream_A<CLLocation,Double,SpeedUnit_I<Double>>(
        runningStream,
        speedEvaluationStream,
        speedUnitStream
) {
    override fun format(number: Double): String = NSString.stringWithFormat("%0.2d", number)
}
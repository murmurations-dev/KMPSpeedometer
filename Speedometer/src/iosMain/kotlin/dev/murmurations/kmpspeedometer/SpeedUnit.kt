package dev.murmurations.kmpspeedometer

import platform.Foundation.NSString
import platform.Foundation.stringWithFormat


//@Suppress("OVERRIDE_BY_INLINE")
sealed interface SpeedUnit : SpeedUnit_I<Double> {
    fun nsString(number: Double): String = NSString.stringWithFormat("%0.2d", number)

    class MetricSystem : SpeedUnit_I.MetricSystem_A<Double>() {
        override fun transform(value: Double): Double { return value }
        // For typed Swift implementation:
        // abstract class MetricSystem
        // abstract override fun transform(value: Double): Double
    }

    class Kmh : SpeedUnit_I.Kmh_A<Double>() {
        override fun transform(value: Double): Double { return value*3.6 }
    }

    class Mph : SpeedUnit_I.Mph_A<Double>() {
        override fun transform(value: Double): Double { return value*2.2369362921 }
    }
}
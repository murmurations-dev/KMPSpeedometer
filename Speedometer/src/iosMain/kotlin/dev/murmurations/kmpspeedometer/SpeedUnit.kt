package dev.murmurations.kmpspeedometer

import platform.Foundation.NSString
import platform.Foundation.stringWithFormat


//@Suppress("OVERRIDE_BY_INLINE")
sealed interface SpeedUnit : SpeedUnit_I {
    fun nsString(number: Float): String = NSString.stringWithFormat("%0.2f", number)

    class MetricSystem : SpeedUnit_I.MetricSystem_A() {
        override fun transform(value: Float): Float { return value }
        // For typed Swift implementation:
        // abstract class MetricSystem
        // abstract override fun transform(value: Double): Double
    }

    class Kmh : SpeedUnit_I.Kmh_A() {
        override fun transform(value: Float): Float { return value*3.6f }
    }

    class Mph : SpeedUnit_I.Mph_A() {
        override fun transform(value: Float): Float { return value*2.2369362921f }
    }
}
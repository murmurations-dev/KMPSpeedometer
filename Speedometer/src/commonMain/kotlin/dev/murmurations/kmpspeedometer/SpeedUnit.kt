package dev.murmurations.kmpspeedometer

interface ValueTransformer {
    fun transform(value: Float): Float
}

interface SpeedUnit_I : ValueTransformer {
    val userDisplay: String

    abstract class MetricSystem_A : SpeedUnit_I { override val userDisplay = "m/s" }
    abstract class Kmh_A : SpeedUnit_I { override val userDisplay = "km/h" }
    abstract class Mph_A : SpeedUnit_I { override val userDisplay = "mph" }
}

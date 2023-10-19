package dev.murmurations.kmpspeedometer

interface ValueTransformer<R> {
    fun transform(value: R): R
}

interface SpeedUnit_I<R> : ValueTransformer<R> {
    val userDisplay: String

    abstract class MetricSystem_A<R> : SpeedUnit_I<R> { override val userDisplay = "m/s" }
    abstract class Kmh_A<R> : SpeedUnit_I<R> { override val userDisplay = "km/h" }
    abstract class Mph_A<R> : SpeedUnit_I<R> { override val userDisplay = "mph" }
}

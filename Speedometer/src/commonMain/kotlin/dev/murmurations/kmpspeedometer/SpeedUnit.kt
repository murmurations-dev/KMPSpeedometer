package dev.murmurations.kmpspeedometer

interface ValueTransformer {
    fun transform(value: Float): Float
}

sealed interface SpeedUnit : ValueTransformer {
    val userDisplay: String

    class MetricSystem : SpeedUnit {
        override val userDisplay = "m/s"
        override fun transform(value: Float): Float { return value }
    }
    class Kmh : SpeedUnit {
        override val userDisplay = "km/h"
        override fun transform(value: Float): Float { return value*3.6f }
    }
    class Mph : SpeedUnit {
        override val userDisplay = "mph"
        override fun transform(value: Float): Float { return value*2.2369362921f }
    }
}

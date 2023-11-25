package dev.murmurations.kmpspeedometer


sealed interface SpeedUnit : ValueTransformer {
    class MetricSystem : SpeedUnit_I.MetricSystem_A() { override fun transform(value: Float): Float { return value } }
    class Kmh : SpeedUnit_I.Kmh_A() { override fun transform(value: Float): Float { return value*3.6f } }
    class Mph : SpeedUnit_I.Mph_A() { override fun transform(value: Float): Float { return value*2.2369362921f } }
}
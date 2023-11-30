package dev.murmurations.kmpspeedometer

open class SpeedUnitStream(
    initialState: SpeedUnit
) : MutableStateStream<SpeedUnit>(initialState)  {
    fun setUnit(unit: SpeedUnit) = setState(unit)
}

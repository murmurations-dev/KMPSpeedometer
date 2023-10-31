package dev.murmurations.kmpspeedometer

abstract class SpeedUnitStream(
    initialState: SpeedUnit
) : MutableStateStream_A<SpeedUnit>(initialState)  {
    fun setUnit(unit: SpeedUnit) = setState(unit)
}

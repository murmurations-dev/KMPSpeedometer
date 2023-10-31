package dev.murmurations.kmpspeedometer

abstract class SpeedUnitStream_T(
    initialState: SpeedUnit_T
) : MutableStateStream_A<SpeedUnit_T>(initialState)  {
    fun setUnit(unit: SpeedUnit_T) = setState(unit)
}

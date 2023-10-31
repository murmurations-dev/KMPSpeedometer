package dev.murmurations.kmpspeedometer

class SpeedUnitStream (
    initialState: SpeedUnit
) : MutableStateStream_A<SpeedUnit>(initialState)  {
    fun setUnit(unit: SpeedUnit) = setState(unit)
}
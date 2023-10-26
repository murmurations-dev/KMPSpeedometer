package dev.murmurations.kmpspeedometer

abstract class SpeedUnitStream_T<Double, SpeedUnit_T>(
    initialState: SpeedUnit_T
) : MutableStateStream_A<SpeedUnit_T>(initialState)  {
//    override fun start() = setState(RunningState.Started())
//    override fun stop() = setState(RunningState.Stopped())
}

package dev.murmurations.kmpspeedometer

interface RunningStream_I : MutableStateStream_I<RunningState> {
    fun start()
    fun stop()
}

abstract class RunningStream_A(
    initialState: RunningState
) : MutableStateStream_A<RunningState>(initialState), RunningStream_I  {
    override fun start() = setState(RunningState.Started)
    override fun stop() = setState(RunningState.Stopped)
}

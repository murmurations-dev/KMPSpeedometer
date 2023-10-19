package dev.murmurations.kmpspeedometer

interface StartedStream_I : MutableStateStream_I<StartedState> {
    fun start()
    fun stop()
}

abstract class StartedStream_A(
    initialState: StartedState
) : MutableStateStream_A<StartedState>(initialState), StartedStream_I  {
    override fun start() = setState(StartedState.Started())
    override fun stop() = setState(StartedState.Stopped())
}

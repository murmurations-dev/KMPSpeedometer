package dev.murmurations.kmpspeedometer

abstract class StartedStream_A(
    initialState: StartedState
) : MutableStateStream<StartedState>(initialState) {
    fun start() = setState(StartedState.Started())
    fun stop() = setState(StartedState.Stopped())
}

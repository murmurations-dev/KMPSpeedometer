package dev.murmurations.kmpspeedometer

sealed interface RunningState {
    object Stopped : RunningState
    object Started : RunningState
}

sealed interface RunningSeed {
    interface Stopped : RunningSeed
    interface Started : RunningSeed
}

fun truc(state: RunningSeed) = when (state) {
    is RunningSeed.Stopped -> print("")
    is RunningSeed.Started -> print("")
}
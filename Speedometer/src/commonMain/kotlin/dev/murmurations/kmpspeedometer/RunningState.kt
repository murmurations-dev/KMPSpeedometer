package dev.murmurations.kmpspeedometer

sealed interface RunningState {
    object Stopped : RunningState
    object Started : RunningState
}

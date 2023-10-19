package dev.murmurations.kmpspeedometer

sealed interface RunningState {
    class Stopped : RunningState
    class Started : RunningState
}

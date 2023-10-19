package dev.murmurations.kmpspeedometer

sealed interface StartedState {
    class Stopped : StartedState
    class Started : StartedState
}

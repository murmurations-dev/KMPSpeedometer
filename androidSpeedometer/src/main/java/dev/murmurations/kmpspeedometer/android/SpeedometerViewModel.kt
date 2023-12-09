package dev.murmurations.kmpspeedometer.android

import androidx.lifecycle.ViewModel
import dev.murmurations.kmpspeedometer.RunningState
import dev.murmurations.kmpspeedometer.RunningStateSeed
import dev.murmurations.kmpspeedometer.RunningStream
import kotlinx.coroutines.flow.MutableStateFlow

class SpeedometerViewModel(
    initialState: RunningState = RunningState.Stopped,
    runningStream: RunningStateSeed = object : RunningStateSeed {
        override val sharedMutableStateFlow = MutableStateFlow(initialState)
    }
) : ViewModel(),
    RunningStateSeed by runningStream
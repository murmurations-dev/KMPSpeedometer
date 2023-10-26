package dev.murmurations.kmpspeedometer.android

import androidx.lifecycle.ViewModel
import dev.murmurations.kmpspeedometer.RunningState
import dev.murmurations.kmpspeedometer.RunningStream
import dev.murmurations.kmpspeedometer.RunningStream_I

class SpeedometerViewModel(
    runningStream: RunningStream = RunningStream(RunningState.Stopped)
) : ViewModel(), RunningStream_I by runningStream
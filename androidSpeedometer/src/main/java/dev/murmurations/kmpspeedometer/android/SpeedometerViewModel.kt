package dev.murmurations.kmpspeedometer.android

import androidx.lifecycle.ViewModel
import dev.murmurations.kmpspeedometer.RunningState
import dev.murmurations.kmpspeedometer.RunningStream

class SpeedometerViewModel(
    val runningStream: RunningStream = RunningStream(RunningState.Stopped)
) : ViewModel() // , RunningStream by runningStream
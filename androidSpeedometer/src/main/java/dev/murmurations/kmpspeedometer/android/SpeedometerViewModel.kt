package dev.murmurations.kmpspeedometer.android

import android.content.Context
import androidx.lifecycle.ViewModel
import dev.murmurations.kmpspeedometer.RunningState
import dev.murmurations.kmpspeedometer.RunningStream
import dev.murmurations.kmpspeedometer.RunningStream_I

//*** val Context.runningStream: RunningStream by lazy { RunningStream(RunningState.Stopped) }

class SpeedometerViewModel(
    runningStream: RunningStream = RunningStream(RunningState.Stopped)
) : ViewModel(), RunningStream_I by runningStream
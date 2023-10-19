package dev.murmurations.kmpspeedometer.android

import androidx.lifecycle.ViewModel
import dev.murmurations.kmpspeedometer.StartedState
import dev.murmurations.kmpspeedometer.StartedStream
import dev.murmurations.kmpspeedometer.StartedStream_I

class SpeedometerViewModel(
    startedStream: StartedStream = StartedStream(StartedState.Stopped())
) : ViewModel(), StartedStream_I by startedStream
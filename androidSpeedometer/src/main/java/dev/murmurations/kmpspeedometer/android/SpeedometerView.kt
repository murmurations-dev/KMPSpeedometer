package dev.murmurations.kmpspeedometer.android

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.murmurations.kmpspeedometer.RunningState

@Composable
fun SpeedometerView(
    model: SpeedometerViewModel = SpeedometerViewModel()
) {
    val runningState by model.sharedMutableStateFlow.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        val text = when (runningState) {
            is RunningState.Stopped -> "Stopped"
            is RunningState.Started -> "Started"
        }
        Text(text)

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = model.start,
            enabled = runningState !is RunningState.Started
        ) {
            Text("Start")
        }

        Button(
            onClick = model.stop,
            enabled = runningState !is RunningState.Stopped
        ) {
            Text("Stop")
        }
    }
}

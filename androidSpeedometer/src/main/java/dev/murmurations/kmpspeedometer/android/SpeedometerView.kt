package dev.murmurations.kmpspeedometer.android

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
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
fun SpeedometerView(model: SpeedometerViewModel) {
    val started by model.flow.collectAsState()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(16.dp)
    ) {
        Text(
            text = "speed",
            fontSize = 18.sp,
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            enabled = (started is RunningState.Stopped),
            onClick = {
                model.start()
            }) {
            Text(text = "Start")
        }
        Button(
            enabled = (started is RunningState.Started),
            onClick = {
                model.stop()
            }) {
            Text(text = "Stop")
        }
    }
}

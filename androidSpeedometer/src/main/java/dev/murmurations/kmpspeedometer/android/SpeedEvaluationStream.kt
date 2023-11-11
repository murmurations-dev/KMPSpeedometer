package dev.murmurations.kmpspeedometer.android

import android.content.Context
import dev.murmurations.kmpspeedometer.SpeedEvaluationStream

val Context.sharedSpeedEvaluationStream: SpeedEvaluationStream by lazy {
    val context = SpeedometerApplication.context
    val updateLocationStream = context.sharedUpdateLocationStream
    SpeedEvaluationStream(updateLocationStream)
}

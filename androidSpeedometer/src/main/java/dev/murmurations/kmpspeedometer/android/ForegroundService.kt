package dev.murmurations.kmpspeedometer.android

import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import androidx.lifecycle.LifecycleService

class ForegroundService: LifecycleService() {
    companion object {
        val notificationChannelId = "foreground-service-notification"
    }

    private lateinit var notificationBuilder: NotificationCompat.Builder

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        when(intent?.action) {
            Actions.START.toString() -> start()
            Actions.STOP.toString() -> stop()
        }
        return super.onStartCommand(intent, flags, startId)
    }

    private fun updateNotification(contentText: String) {
        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationBuilder.setContentText(contentText)
        notificationManager.notify(1, notificationBuilder.build())
    }

    private fun start() {
        val channelId = notificationChannelId
        notificationBuilder = NotificationCompat.Builder(this, channelId)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle("Speed evaluation")
            .setContentText("Starting location updates…")
            .setOngoing(true)
        val notification = notificationBuilder.build()

//        val speedPipe = SpeedPipe.shared
////        val displayFlow = SpeedDisplayFlow(speedDataFlow, SpeedMetric.ms())
//        speedPipe.started
//            .onEach(::updateNotification)
//            .launchIn(lifecycleScope)

        startForeground(1, notification)
    }

    private fun stop() {
        stopForeground(STOP_FOREGROUND_REMOVE)
        stopSelf()
    }

    enum class Actions {
        START, STOP
    }
}

private fun Context.foregroundService(action: String) {
    Intent(this, ForegroundService::class.java).also { intent ->
        intent.action = action
        this.startService(intent)
    }
}

fun Context.startForegroundService() {
    foregroundService(ForegroundService.Actions.START.toString())
}

fun Context.stopForegroundService() {
    foregroundService(ForegroundService.Actions.STOP.toString())
}



package dev.murmurations.kmpspeedometer.android

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Bundle
import co.touchlab.kermit.Logger

object ActivityLifecycleListener : Application.ActivityLifecycleCallbacks {
    override fun onActivityDestroyed(activity: Activity) {
        Logger.i("onActivityDestroyed at ${activity.localClassName}")
        clearReferences(activity)
    }

    override fun onActivityResumed(activity: Activity) {
        Logger.i("onActivityResumed at ${activity.localClassName}")
        SpeedometerApplication.currentActivity = activity
    }

    override fun onActivityPaused(activity: Activity) {
        Logger.i("onActivityPaused at ${activity.localClassName}")
        clearReferences(activity)
    }

    override fun onActivityCreated(p0: Activity, p1: Bundle?) {}
    override fun onActivityStarted(p0: Activity) {}
    override fun onActivitySaveInstanceState(p0: Activity, p1: Bundle) {}
    override fun onActivityStopped(p0: Activity) {}

    private fun clearReferences(activity: Activity){
        val currentActivity = SpeedometerApplication.currentActivity
        if (activity.equals(currentActivity))
            SpeedometerApplication.currentActivity = null
    }
}

class SpeedometerApplication : Application() {
    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context

        @SuppressLint("StaticFieldLeak")
        var currentActivity: Activity? = null
    }


    override fun onCreate() {
        super.onCreate()
        context = applicationContext

        registerActivityLifecycleCallbacks(ActivityLifecycleListener)

        val channel = NotificationChannel(
            ForegroundService.notificationChannelId,
            "Foreground Service Notifications",
            NotificationManager.IMPORTANCE_LOW
        )
        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(channel)
    }
}
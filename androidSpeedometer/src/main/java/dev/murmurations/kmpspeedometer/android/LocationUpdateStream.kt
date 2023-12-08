package dev.murmurations.kmpspeedometer.android

import android.Manifest
import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import android.location.Location
import android.location.LocationManager
import android.os.Build
import android.os.Looper
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.LocationServices
import dev.murmurations.kmpspeedometer.LocationUpdateStream_T

val Context.sharedUpdateLocationStream: LocationUpdateStream by lazy { LocationUpdateStream() }

class LocationUpdateStream(
    val locationIntervalMillis: Long = 1000
) : LocationUpdateStream_T() {
    val context = SpeedometerApplication.context

    @SuppressLint("MissingPermission")
    override fun startLocationUpdates(updateLocation: (Location) -> (Unit)): () -> (Unit) {
//        if(!context.hasLocationPermission()) {
//            throw LocationClient.LocationException("Missing location permission")
//        }

        val locationManager = context.getSystemService(Application.LOCATION_SERVICE) as LocationManager
        val isGpsEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)
        val isNetworkEnabled = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)
//        if(!isGpsEnabled && !isNetworkEnabled) {
//            throw LocationClient.LocationException("GPS is disabled")
//        }

        val request = LocationRequest
            .Builder(locationIntervalMillis)
            .build()

        val locationCallback = object : LocationCallback() {
            override fun onLocationResult(result: LocationResult) {
                super.onLocationResult(result)
                result.locations.lastOrNull()?.let { location ->
                    // Logger.i { "Location: $location" }
                    updateLocation(location)
                }
            }
        }

        val client = LocationServices.getFusedLocationProviderClient(context)

        // Logger.i { "Start location updates" }
        context.startForegroundService()
        client.requestLocationUpdates(
            request,
            locationCallback,
            Looper.getMainLooper()
        )

        return {
            // Logger.i { "Stop location updates" }
            client.removeLocationUpdates(locationCallback)
            context.stopForegroundService()
        }
    }
}


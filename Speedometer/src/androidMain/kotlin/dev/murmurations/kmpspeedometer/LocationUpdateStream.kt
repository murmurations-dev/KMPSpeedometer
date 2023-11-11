package dev.murmurations.kmpspeedometer

import android.location.Location

abstract class LocationUpdateStream_T : LocationUpdateStream_A<Location>() {
    abstract override fun startLocationUpdates(updateLocation: (Location) -> (Unit)): () -> (Unit)
}
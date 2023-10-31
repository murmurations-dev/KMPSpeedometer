package dev.murmurations.kmpspeedometer

import platform.CoreLocation.CLLocation

abstract class LocationUpdateStream : LocationUpdateStream_A<CLLocation>() {
    abstract override fun startLocationUpdates(updateLocation: (CLLocation) -> (Unit)): () -> (Unit)
}
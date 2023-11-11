package dev.murmurations.kmpspeedometer

import com.rickclephas.kmp.nativecoroutines.NativeCoroutines
import platform.CoreLocation.CLLocation

abstract class LocationUpdateStream_T : LocationUpdateStream_A<CLLocation>() {
    abstract override fun startLocationUpdates(updateLocation: (CLLocation) -> (Unit)): () -> (Unit)

    //*** Progress
    @OptIn(kotlin.experimental.ExperimentalObjCName::class)
    @NativeCoroutines
    val locationUpdateFlow = super.flow
}
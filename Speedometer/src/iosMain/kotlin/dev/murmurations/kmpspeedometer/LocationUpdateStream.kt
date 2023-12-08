package dev.murmurations.kmpspeedometer

import kotlinx.coroutines.flow.SharedFlow
import com.rickclephas.kmp.nativecoroutines.NativeCoroutines
import platform.CoreLocation.CLLocation

abstract class LocationUpdateStream : LocationUpdateStream_A<CLLocation>() {
    abstract override fun startLocationUpdates(updateLocation: (CLLocation) -> (Unit)): () -> (Unit)

    //*** Progress
    @OptIn(kotlin.experimental.ExperimentalObjCName::class)
    @NativeCoroutines
    val locationUpdateFlow = super.flow
}

interface LocationUpdateCLLocation : LocationUpdateSeed<CLLocation> {
    override fun startLocationUpdates(updateLocation: (CLLocation) -> (Unit)): () -> (Unit)

    @OptIn(kotlin.experimental.ExperimentalObjCName::class)
    @NativeCoroutines
    val locationUpdateFlow: SharedFlow<CLLocation>
        get() = flow
}
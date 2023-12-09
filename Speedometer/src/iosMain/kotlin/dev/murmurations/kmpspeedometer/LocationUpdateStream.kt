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

interface LocationUpdateCLLocation2 /* : LocationUpdateSeed<CLLocation> */ {
    val startLocationUpdates3: ((CLLocation) -> Unit) -> () -> Unit
//    override fun startLocationUpdates2(updateLocation: (CLLocation) -> (Unit)): () -> (Unit)
}

abstract class LocationUpdateCLLocation : LocationUpdateSeed<CLLocation> {
    abstract val startLocationUpdates3: ((CLLocation) -> Unit) -> () -> Unit
    abstract override fun startLocationUpdates2(updateLocation: (CLLocation) -> (Unit)): () -> (Unit)

    // public final val a: KFunction1<(CLLocation) -> Unit, () -> Unit>
    val a = ::startLocationUpdates2
    abstract val b: ((CLLocation) -> Unit) -> () -> Unit

    @OptIn(kotlin.experimental.ExperimentalObjCName::class)
    @NativeCoroutines
    val locationUpdateFlow: SharedFlow<CLLocation>
        get() = flow
}
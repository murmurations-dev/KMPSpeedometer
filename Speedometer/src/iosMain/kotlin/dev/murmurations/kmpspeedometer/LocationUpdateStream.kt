package dev.murmurations.kmpspeedometer

import kotlinx.coroutines.flow.SharedFlow
import com.rickclephas.kmp.nativecoroutines.NativeCoroutines
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.shareIn
import kotlinx.coroutines.launch
import platform.CoreLocation.CLLocation
import kotlin.coroutines.EmptyCoroutineContext

abstract class LocationUpdateStream : LocationUpdateStream_A<CLLocation>() {
    abstract override fun startLocationUpdates(updateLocation: (CLLocation) -> (Unit)): () -> (Unit)

    //*** Progress
    @OptIn(kotlin.experimental.ExperimentalObjCName::class)
    @NativeCoroutines
    val locationUpdateFlow = super.flow
}

fun sharingScope() = CoroutineScope(EmptyCoroutineContext)

interface LocationUpdateBase<L> {
//    val startLocationUpdates3: ((L) -> Unit) -> () -> Unit
//
//    val locationUpdatesSharing: SharedStream_I<L>
//        get() =  object : SharedStream_I<L> {
//            private val sharingScope = CoroutineScope(EmptyCoroutineContext)
//
//            override val flow = callbackFlow {
//                val stopLocationUpdates = startLocationUpdates3({ launch { send(it) } })
//                awaitClose(stopLocationUpdates)
//            }.shareIn(sharingScope, SharingStarted.WhileSubscribed())
//        }
}

interface LocationUpdateCLLocation2 : LocationUpdateBase<CLLocation> {
    val startLocationUpdates3: ((CLLocation) -> Unit) -> () -> Unit
    //val locationUpdatesSharing: SharedStream_I<CLLocation>
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
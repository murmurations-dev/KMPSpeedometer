package dev.murmurations.kmpspeedometer

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.shareIn
import kotlinx.coroutines.launch
import kotlin.coroutines.EmptyCoroutineContext

interface LocationUpdateStream_I<L> : SharedStream_I<L> {
    fun startLocationUpdates(updateLocation: (L) -> (Unit)): () -> (Unit)
}

abstract class LocationUpdateStream_A<L> : LocationUpdateStream_I<L> {
    private val sharingScope = CoroutineScope(EmptyCoroutineContext)

    override val flow = callbackFlow {
        val stopLocationUpdates = startLocationUpdates({ launch { send(it) } })
        awaitClose(stopLocationUpdates)
    }.shareIn(sharingScope, SharingStarted.WhileSubscribed())
}

interface LocationUpdateSeed<L> {
    fun startLocationUpdates2(updateLocation: (L) -> (Unit)): () -> (Unit)

    private val sharingScope: CoroutineScope
        get() = CoroutineScope(EmptyCoroutineContext)

    val flow: SharedFlow<L>
        get() = callbackFlow {
            val stopLocationUpdates = startLocationUpdates2({ launch { send(it) } })
            awaitClose(stopLocationUpdates)
        }.shareIn(sharingScope, SharingStarted.WhileSubscribed())
}

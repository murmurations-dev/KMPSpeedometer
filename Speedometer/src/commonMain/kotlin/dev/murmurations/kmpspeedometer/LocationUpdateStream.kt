package dev.murmurations.kmpspeedometer

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.shareIn
import kotlinx.coroutines.launch

interface LocationUpdateStream_I<L> {
    fun startLocationUpdates(updateLocation: (L) -> (Unit)): () -> (Unit)
}

abstract class LocationUpdateStream_A<L> : SharedStream_I<L>, LocationUpdateStream_I<L> {
    private val sharingScope = CoroutineScope(CoroutineName("LocationUpdateStream"))

    override val flow = callbackFlow {
        val stopLocationUpdates = startLocationUpdates({ launch { send(it) } })
        awaitClose(stopLocationUpdates)
    }.shareIn(sharingScope, SharingStarted.WhileSubscribed())
}
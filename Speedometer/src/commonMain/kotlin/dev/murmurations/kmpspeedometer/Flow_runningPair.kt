package dev.murmurations.kmpspeedometer

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.drop
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.scan

fun <T> Flow<T>.runningPair(): Flow<Pair<T, T>> =
    scan(Pair<T?,T?>(null, null)) { accumulator, element ->
        Pair(accumulator.second, element)
    }
    .drop(2)
    .map {
        val (first, second) = it
        Pair(first!!, second!!)
    }


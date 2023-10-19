package dev.murmurations.kmpspeedometer

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
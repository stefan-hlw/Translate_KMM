package com.pepa.translate_kmm

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
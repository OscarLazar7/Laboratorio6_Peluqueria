package com.prueba1.mediturnos

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
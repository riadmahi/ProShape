package com.riadmahi.proshape

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
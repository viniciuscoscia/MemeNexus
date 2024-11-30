package com.viniciuscoscia.memenexus

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
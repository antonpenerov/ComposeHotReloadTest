package com.example.composehotreloadtest

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
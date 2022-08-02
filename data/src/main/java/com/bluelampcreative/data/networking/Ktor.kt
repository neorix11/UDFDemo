package com.bluelampcreative.data.networking

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

fun createHttpClient() = HttpClient(CIO) {
    install(ContentNegotiation) {
        json(Json{
            ignoreUnknownKeys = true
            isLenient = true
        })
    }
    install(Logging) {
        logger = Logger.DEFAULT
        level = LogLevel.ALL
    }

}
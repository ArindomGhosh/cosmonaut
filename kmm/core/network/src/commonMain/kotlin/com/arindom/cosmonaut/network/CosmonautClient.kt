package com.arindom.cosmonaut.network

import io.ktor.client.*
import io.ktor.client.engine.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

fun getHttpClient(
    baseUrl: String,
    enableNetworkLogs: Boolean
) = HttpClient(platformClientEngineModule()) {
    defaultRequest {
        url {
            protocol = URLProtocol.HTTPS
            host = baseUrl
        }
    }
    install(ContentNegotiation) {
        json(
            Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
                coerceInputValues = true
            }
        )
    }
    if (enableNetworkLogs) {
        install(Logging) {
            // todo check napier
            logger = Logger.SIMPLE
            level = LogLevel.ALL
        }
    }
}
expect fun platformClientEngineModule(): HttpClientEngine
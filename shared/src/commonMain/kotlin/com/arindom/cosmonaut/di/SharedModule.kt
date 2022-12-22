package com.arindom.cosmonaut.di

import io.ktor.client.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import org.koin.core.module.Module
import org.koin.dsl.module

fun sharedModule(enableNetworkLogs: Boolean) = module {
    includes(
        clientModule(enableNetworkLogs),
        servicesModule,
        repositoriesModule,
        useCasesModule,
        presenterModule
    )
}

private val clientModule: (Boolean) -> Module = { enableNetworkLogs ->
    module {
        single {
            HttpClient(get()) {
                defaultRequest {
                    url {
                        protocol = URLProtocol.HTTPS
                        host = "api.spacexdata.com"
                        path("v4/")
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
        }
    }
}

expect fun platformModule(): Module

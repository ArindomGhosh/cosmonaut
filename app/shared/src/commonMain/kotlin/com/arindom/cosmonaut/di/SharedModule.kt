package com.arindom.cosmonaut.di

import com.arindom.cosmonaut.domain.repositories.SpaceXRepo
import com.arindom.cosmonaut.domain.usecasses.GetLaunchesUseCase
import com.arindom.cosmonaut.infra.network.SpacexLaunchServices
import com.arindom.cosmonaut.infra.repos.SpacexRepoImpl
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

    single { SpacexLaunchServices(get()) }
    single<SpaceXRepo> { SpacexRepoImpl(get()) }
    single { GetLaunchesUseCase(get()) }
}

expect fun platformModule(): Module

package com.arindom.cosmonaut.spacex.di

import com.arindom.cosmonaut.network.getHttpClient
import com.arindom.cosmonaut.spacex.SpacexLaunchServices
import org.koin.core.module.Module
import org.koin.dsl.module

val spacexServiceModule: (Boolean) -> Module = { enableNetworkLogs ->
    module {
        single {
            getHttpClient(
                baseUrl = "api.spacexdata.com",
                enableNetworkLogs = enableNetworkLogs
            )
        }
        single { SpacexLaunchServices(get()) }
    }
}

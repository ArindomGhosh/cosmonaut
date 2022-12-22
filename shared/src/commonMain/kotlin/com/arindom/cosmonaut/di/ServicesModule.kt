package com.arindom.cosmonaut.di

import com.arindom.cosmonaut.infra.network.SpacexLaunchServices
import org.koin.dsl.module

internal val servicesModule = module {
    single { SpacexLaunchServices(get()) }
}
package com.arindom.cosmonaut.feature.spacexlaunches.di

import com.arindom.cosmonaut.feature.spacexlaunches.domain.usecasses.GetLaunchesUseCase
import org.koin.dsl.module

internal val useCasesModule = module {
    single { GetLaunchesUseCase(get()) }
}
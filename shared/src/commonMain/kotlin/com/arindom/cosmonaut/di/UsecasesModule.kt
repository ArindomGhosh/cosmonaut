package com.arindom.cosmonaut.di

import com.arindom.cosmonaut.domain.usecasses.GetLaunchesUseCase
import org.koin.dsl.module

internal val useCasesModule = module {
    single { GetLaunchesUseCase(get()) }
}
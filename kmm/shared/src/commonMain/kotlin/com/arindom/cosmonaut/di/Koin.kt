package com.arindom.cosmonaut.di

import com.arindom.cosmonaut.feature.spacexlaunches.di.spaceXLaunchesFeatureModule
import com.arindom.cosmonaut.feature.spacexlaunches.domain.usecasses.GetLaunchesUseCase
import com.arindom.cosmonaut.feature.spacexlaunches.presentation.MainActivityPresenter
import org.koin.core.Koin
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

fun initKoin(enableNetworkLogs: Boolean = false, appDeclaration: KoinAppDeclaration = {}) =
    startKoin {
        appDeclaration()
        modules(
            featureModules(enableNetworkLogs)
        )
    }

val featureModules: (Boolean) -> Module = { isDebug ->
    module {
        includes(
            spaceXLaunchesFeatureModule(isDebug)
        )
    }
}

fun KoinApplication.Companion.start(): KoinApplication = initKoin { }

val Koin.getLaunchesUseCase: GetLaunchesUseCase
    get() = get()

val Koin.mainActivityPresenter: MainActivityPresenter
    get() = get()


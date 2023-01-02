package com.arindom.cosmonaut.feature.spacexlaunches.di

import com.arindom.cosmonaut.spacex.di.spacexServiceModule
import org.koin.dsl.module

fun spaceXLaunchesFeatureModule(isDebug: Boolean) = module {
    includes(
        spacexServiceModule(isDebug),
        repositoriesModule,
        useCasesModule,
        presenterModule
    )
}

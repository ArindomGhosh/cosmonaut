package com.arindom.cosmonaut.di

import com.arindom.cosmonaut.domain.usecasses.GetLaunchesUseCase
import com.arindom.cosmonaut.presentation.MainActivityPresenter
import org.koin.core.Koin
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

fun initKoin(enableNetworkLogs: Boolean = false, appDeclaration: KoinAppDeclaration = {}) =
    startKoin {
        appDeclaration()
        modules(
            platformModule(),
            sharedModule(enableNetworkLogs)
        )
    }


fun KoinApplication.Companion.start(): KoinApplication = initKoin { }

val Koin.getLaunchesUseCase: GetLaunchesUseCase
    get() = get()

val Koin.mainActivityPresenter: MainActivityPresenter
    get() = get()


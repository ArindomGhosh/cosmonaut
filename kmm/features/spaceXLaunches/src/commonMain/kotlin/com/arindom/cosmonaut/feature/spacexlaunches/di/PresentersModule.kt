package com.arindom.cosmonaut.feature.spacexlaunches.di

import com.arindom.cosmonaut.feature.spacexlaunches.presentation.MainActivityPresenter
import org.koin.dsl.module

val presenterModule = module {
    factory {
        MainActivityPresenter(get())
    }
}
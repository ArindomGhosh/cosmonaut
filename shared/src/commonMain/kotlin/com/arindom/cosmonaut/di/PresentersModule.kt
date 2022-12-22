package com.arindom.cosmonaut.di

import com.arindom.cosmonaut.presentation.MainActivityPresenter
import org.koin.dsl.module

val presenterModule = module {
    factory {
        MainActivityPresenter(get())
    }
}
package com.arindom.cosmonaut.androidApp.di

import com.arindom.cosmonaut.androidApp.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val androidModule = module {
    viewModel {
        MainViewModel(get())
    }
}
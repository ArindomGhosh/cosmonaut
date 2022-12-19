package com.arindom.cosmonaut.di

import io.ktor.client.engine.okhttp.*
import org.koin.dsl.module

actual fun platformModule() = module {
    single {
        OkHttp.create()
    }
}
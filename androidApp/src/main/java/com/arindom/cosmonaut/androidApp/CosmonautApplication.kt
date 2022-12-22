package com.arindom.cosmonaut.androidApp

import android.app.Application
import com.arindom.cosmonaut.BuildConfig
import com.arindom.cosmonaut.androidApp.di.viewModelsModule
import com.arindom.cosmonaut.di.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.logger.Level

class CosmonautApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        initKoin(
            enableNetworkLogs = BuildConfig.DEBUG
        ) {
            androidLogger(level = if (BuildConfig.DEBUG) Level.ERROR else Level.NONE)
            androidContext(this@CosmonautApplication)
            modules(
                viewModelsModule
            )
        }
    }
}
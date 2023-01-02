package com.arindom.cosmonaut.network

import io.ktor.client.engine.okhttp.*

actual fun platformClientEngineModule() =
    OkHttp.create()

package com.arindom.cosmonaut.network

import io.ktor.client.engine.darwin.*

actual fun platformClientEngineModule() = Darwin.create()
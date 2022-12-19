package com.arindom.cosmonaut.infra.network

import com.arindom.cosmonaut.infra.network.dtos.RocketLaunch
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*

class SpacexLaunchServices(private val httpClient: HttpClient) {
    suspend fun getLaunches(): List<RocketLaunch> {
        return httpClient.get("launches").body()
    }
}
package com.arindom.cosmonaut.spacex

import com.arindom.cosmonaut.spacex.dtos.RocketLaunch
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*

class SpacexLaunchServices(private val httpClient: HttpClient) {
    suspend fun getLaunches(): List<RocketLaunch> {
        return httpClient.get("v4/launches").body()
    }
}
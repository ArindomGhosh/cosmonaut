package com.arindom.cosmonaut.feature.spacexlaunches.domain.entities

import com.arindom.cosmonaut.spacex.dtos.RocketLaunch

data class RocketLaunchEntity(
    val launchId: String,
    val rocketId: String,
    val isSuccessful: Boolean,
    val missionName: String,
    val launchDate: String,
    val launchDetails: String,
)

fun RocketLaunch.toRocketLaunchEntity() =
    RocketLaunchEntity(
        launchId = this.launchId,
        rocketId = this.rocketId,
        isSuccessful = this.launchSuccess ?: false,
        missionName = this.missionName,
        launchDate = this.launchDateUTC,
        launchDetails = this.launchDetails
    )

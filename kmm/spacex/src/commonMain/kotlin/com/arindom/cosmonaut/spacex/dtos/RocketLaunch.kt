package com.arindom.cosmonaut.spacex.dtos

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RocketLaunch(
    @SerialName("id") val launchId: String,
    @SerialName("rocket") val rocketId: String,
    @SerialName("flight_number") val flightNumber: Int,
    @SerialName("name") val missionName: String,
    @SerialName("date_utc") val launchDateUTC: String,
    @SerialName("success") val launchSuccess: Boolean?,
    @SerialName("details") val launchDetails: String = ""
)
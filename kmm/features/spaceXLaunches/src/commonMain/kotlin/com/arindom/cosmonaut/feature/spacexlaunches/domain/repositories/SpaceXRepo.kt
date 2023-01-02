package com.arindom.cosmonaut.feature.spacexlaunches.domain.repositories

import com.arindom.cosmonaut.core.data.infra.Resource
import com.arindom.cosmonaut.spacex.dtos.RocketLaunch

interface SpaceXRepo {
    suspend fun getLaunches(): Resource<List<RocketLaunch>>
}
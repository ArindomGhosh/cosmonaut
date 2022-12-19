package com.arindom.cosmonaut.domain.repositories

import com.arindom.cosmonaut.infra.utils.Resource
import com.arindom.cosmonaut.infra.network.dtos.RocketLaunch

interface SpaceXRepo {
    suspend fun getLaunches(): Resource<List<RocketLaunch>>
}
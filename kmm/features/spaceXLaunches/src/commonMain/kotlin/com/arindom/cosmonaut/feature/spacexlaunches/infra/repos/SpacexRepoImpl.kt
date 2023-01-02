package com.arindom.cosmonaut.feature.spacexlaunches.infra.repos

import com.arindom.cosmonaut.core.data.infra.Resource
import com.arindom.cosmonaut.feature.spacexlaunches.domain.repositories.SpaceXRepo
import com.arindom.cosmonaut.spacex.dtos.RocketLaunch
import com.arindom.cosmonaut.spacex.SpacexLaunchServices
import com.arindom.cosmonaut.spacex.utils.safeApiCall


internal class SpacexRepoImpl(private val spacexLaunchServices: SpacexLaunchServices) : SpaceXRepo {

    override suspend fun getLaunches(): Resource<List<RocketLaunch>> {
        return safeApiCall {
            spacexLaunchServices.getLaunches()
        }
    }
}

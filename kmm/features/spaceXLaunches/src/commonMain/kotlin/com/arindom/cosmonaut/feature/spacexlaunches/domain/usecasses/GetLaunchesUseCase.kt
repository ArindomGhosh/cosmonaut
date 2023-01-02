package com.arindom.cosmonaut.feature.spacexlaunches.domain.usecasses

import com.arindom.cosmonaut.core.data.domain.DomainWrapper
import com.arindom.cosmonaut.core.data.domain.toDomainMapper
import com.arindom.cosmonaut.feature.spacexlaunches.domain.entities.RocketLaunchEntity
import com.arindom.cosmonaut.feature.spacexlaunches.domain.entities.toRocketLaunchEntity
import com.arindom.cosmonaut.feature.spacexlaunches.domain.repositories.SpaceXRepo

class GetLaunchesUseCase(
    private val spaceXRepo: SpaceXRepo
) {
    suspend operator fun invoke(): DomainWrapper<List<RocketLaunchEntity>> {
        return spaceXRepo.getLaunches()
            .toDomainMapper{
                this.map {
                    it.toRocketLaunchEntity()
                }
            }
    }
}
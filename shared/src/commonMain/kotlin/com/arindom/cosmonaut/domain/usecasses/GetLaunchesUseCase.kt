package com.arindom.cosmonaut.domain.usecasses

import com.arindom.cosmonaut.domain.entities.RocketLaunchEntity
import com.arindom.cosmonaut.domain.entities.toRocketLaunchEntity
import com.arindom.cosmonaut.domain.repositories.SpaceXRepo
import com.arindom.cosmonaut.domain.util.DomainWrapper
import com.arindom.cosmonaut.domain.util.toDomainMapper

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
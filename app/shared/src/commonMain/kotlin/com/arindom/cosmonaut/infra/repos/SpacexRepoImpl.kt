package com.arindom.cosmonaut.infra.repos

import com.arindom.cosmonaut.domain.repositories.SpaceXRepo
import com.arindom.cosmonaut.infra.utils.Resource
import com.arindom.cosmonaut.infra.network.SpacexLaunchServices
import com.arindom.cosmonaut.infra.network.dtos.RocketLaunch
import com.arindom.cosmonaut.infra.utils.safeApiCall


class SpacexRepoImpl(private val spacexLaunchServices: SpacexLaunchServices) : SpaceXRepo {
    /*private val _httpClient = HttpClient(getPlatformHttpEngine()) {
        defaultRequest {
            url {
                protocol = URLProtocol.HTTPS
                host = "api.spacexdata.com"
                path("v4/")
            }
        }
        install(ContentNegotiation) {
            json(
                Json {
                    prettyPrint = true
                    isLenient = true
                    ignoreUnknownKeys = true
                }
            )
        }
        install(Logging) {
            // todo check napier
            logger = Logger.SIMPLE
            level = LogLevel.ALL
        }
    }*/

    override suspend fun getLaunches(): Resource<List<RocketLaunch>> {
        return safeApiCall {
            spacexLaunchServices.getLaunches()
        }
    }
}

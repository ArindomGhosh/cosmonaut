package com.arindom.cosmonaut.feature.spacexlaunches.di

import com.arindom.cosmonaut.feature.spacexlaunches.domain.repositories.SpaceXRepo
import com.arindom.cosmonaut.feature.spacexlaunches.infra.repos.SpacexRepoImpl
import org.koin.dsl.module

internal val repositoriesModule = module {
    single<SpaceXRepo> { SpacexRepoImpl(get()) }
}
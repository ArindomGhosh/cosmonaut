package com.arindom.cosmonaut.di

import com.arindom.cosmonaut.domain.repositories.SpaceXRepo
import com.arindom.cosmonaut.infra.repos.SpacexRepoImpl
import org.koin.dsl.module

internal val repositoriesModule = module {
    single<SpaceXRepo> { SpacexRepoImpl(get()) }
}
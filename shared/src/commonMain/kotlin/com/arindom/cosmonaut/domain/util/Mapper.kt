package com.arindom.cosmonaut.domain.util

import com.arindom.cosmonaut.domain.entities.UiError
import com.arindom.cosmonaut.infra.utils.Resource

inline fun <reified EntityType : Any, Source : Any> Resource<Source>.toDomainMapper(mapper: Source.() -> EntityType): DomainWrapper<EntityType> {
    return when (this) {
        is Resource.Failure -> DomainWrapper.Error(UiError(this.errorCode, this.errorMessage))
        is Resource.Success -> DomainWrapper.Entity(this.data.mapper())
    }
}
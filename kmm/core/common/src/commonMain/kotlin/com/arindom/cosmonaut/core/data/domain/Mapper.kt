package com.arindom.cosmonaut.core.data.domain

import com.arindom.cosmonaut.core.data.domain.models.UiError
import com.arindom.cosmonaut.core.data.infra.Resource

inline fun <reified EntityType : Any, Source : Any> Resource<Source>.toDomainMapper(mapper: Source.() -> EntityType): DomainWrapper<EntityType> {
    return when (this) {
        is Resource.Failure -> DomainWrapper.Error(UiError(this.errorCode, this.errorMessage))
        is Resource.Success -> DomainWrapper.Entity(this.data.mapper())
    }
}
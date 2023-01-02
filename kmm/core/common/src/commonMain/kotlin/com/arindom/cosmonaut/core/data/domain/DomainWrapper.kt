package com.arindom.cosmonaut.core.data.domain

import com.arindom.cosmonaut.core.data.domain.models.UiError

sealed interface DomainWrapper<EntityType : Any> {
    data class Entity<EntityType : Any>(val data: EntityType) : DomainWrapper<EntityType>
    data class Error<EntityType : Any>(val uiError: UiError) : DomainWrapper<EntityType>
}
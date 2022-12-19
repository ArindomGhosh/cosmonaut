package com.arindom.cosmonaut.domain.util

import com.arindom.cosmonaut.domain.entities.UiError

sealed interface DomainWrapper<EntityType : Any> {
    data class Entity<EntityType : Any>(val data: EntityType) : DomainWrapper<EntityType>
    data class Error<EntityType : Any>(val uiError: UiError) : DomainWrapper<EntityType>
}
package com.arindom.cosmonaut.core.data.infra

sealed interface Resource<ResponseType : Any> {
    data class Success<ResponseType : Any>(val data: ResponseType) : Resource<ResponseType>
    data class Failure<ResponseType : Any>(val errorCode: Int, val errorMessage: String) :
        Resource<ResponseType>
}
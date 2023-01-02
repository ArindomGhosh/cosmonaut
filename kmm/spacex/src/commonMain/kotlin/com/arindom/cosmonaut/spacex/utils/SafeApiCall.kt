package com.arindom.cosmonaut.spacex.utils

import com.arindom.cosmonaut.core.data.infra.Resource
import io.ktor.client.plugins.*
import io.ktor.client.statement.*

suspend fun <T : Any> safeApiCall(apiCall: suspend () -> T): Resource<T> {
    return try {
        Resource.Success(apiCall())
    } catch (exception: Exception) {
        when (exception) {
            is ResponseException -> {
                Resource.Failure(
                    exception.response.status.value,
                    exception.response.bodyAsText()
                )
            }
            else -> {
                Resource.Failure(
                    0,
                    "Unknown Error"
                )
            }
        }
    }
}


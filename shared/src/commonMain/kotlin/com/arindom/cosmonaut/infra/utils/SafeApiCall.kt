package com.arindom.cosmonaut.infra.utils

import io.ktor.client.plugins.*
import io.ktor.client.statement.*

suspend fun <T : Any> safeApiCall(apiCall: suspend () -> T): Resource<T> {
    return try {
        Resource.Success(apiCall())
    } /*catch (redirectResponseException: RedirectResponseException) {
        ApiResponse.Failure(
            redirectResponseException.response.status.value,
            redirectResponseException.response.bodyAsText()
        )
    } catch (clientResponseException: ClientRequestException) {
        ApiResponse.Failure(
            clientResponseException.response.status.value,
            clientResponseException.response.bodyAsText()
        )
    } catch (serverResponseException: ServerResponseException) {
        ApiResponse.Failure(
            serverResponseException.response.status.value,
            serverResponseException.response.bodyAsText()
        )
    } */ catch (exception: Exception) {
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


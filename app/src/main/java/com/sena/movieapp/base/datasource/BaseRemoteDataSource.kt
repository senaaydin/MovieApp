package com.sena.movieapp.base.datasource

import com.sena.movieapp.base.usecase.Failure
import com.squareup.moshi.JsonDataException

open class BaseRemoteDataSource {
    suspend fun <O> invoke(serviceFunction: suspend () -> O): O {
        return try {
            serviceFunction()
        } catch (exception: Exception) {
            throw asFailure(exception)
        }
    }

    private fun asFailure(exception: Exception): Failure {
        return when (exception) {
            is Failure -> exception
            is JsonDataException -> Failure.JsonError()
            else -> Failure.UnknownError(exception)
        }

    }
}
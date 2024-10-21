package com.sarfaraj.foodorderingapp.common

import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException

interface ApiCallHelper {

    suspend fun <T> handleApiCall(apiCall: suspend () -> Response<T>): NetworkResult<T> {
        return try {
            val response = apiCall.invoke()
            if (response.isSuccessful && response.body() != null) {
                NetworkResult.Success(response.body()!!)
            } else {
                NetworkResult.Failure(response.message(), response.code())
            }
        } catch (e: Exception) {
            when (e) {
                is HttpException -> {
                    NetworkResult.Failure(e.message(), e.code())
                }

                is IOException -> {
                    NetworkResult.Failure("Slow Network Error", 5)
                }

                else -> {
                    NetworkResult.Failure(e.message, null)
                }
            }
        }
    }

}
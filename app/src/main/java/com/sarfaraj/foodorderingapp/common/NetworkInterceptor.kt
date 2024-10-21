package com.sarfaraj.foodorderingapp.common

import okhttp3.Interceptor
import okhttp3.Response

class NetworkInterceptor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
        request.addHeader("Accept", "application/json")
        return chain.proceed(request.build())
    }
}
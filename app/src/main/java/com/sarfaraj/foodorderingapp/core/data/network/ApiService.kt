package com.sarfaraj.foodorderingapp.core.data.network

import com.sarfaraj.foodorderingapp.core.data.network.dto.JuiceResponse
import com.sarfaraj.foodorderingapp.core.data.network.dto.PizzaResponse
import retrofit2.Response

interface ApiService {
    suspend fun getPizza(): Response<PizzaResponse>

    suspend fun getJuice(): Response<JuiceResponse>
}
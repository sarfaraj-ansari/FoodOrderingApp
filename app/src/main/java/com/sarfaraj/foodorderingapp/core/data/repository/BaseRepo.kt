package com.sarfaraj.foodorderingapp.core.data.repository

import com.sarfaraj.foodorderingapp.common.NetworkResult
import com.sarfaraj.foodorderingapp.core.data.network.dto.JuiceResponse
import com.sarfaraj.foodorderingapp.core.data.network.dto.PizzaResponse

interface BaseRepo {

    suspend fun getPizza(): NetworkResult<PizzaResponse>

    suspend fun getJuice(): NetworkResult<JuiceResponse>
}
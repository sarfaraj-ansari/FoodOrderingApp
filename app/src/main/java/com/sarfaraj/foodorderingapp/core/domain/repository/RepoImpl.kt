package com.sarfaraj.foodorderingapp.core.domain.repository

import com.sarfaraj.foodorderingapp.common.ApiCallHelper
import com.sarfaraj.foodorderingapp.common.NetworkResult
import com.sarfaraj.foodorderingapp.core.data.network.ApiService
import com.sarfaraj.foodorderingapp.core.data.network.dto.JuiceResponse
import com.sarfaraj.foodorderingapp.core.data.network.dto.PizzaResponse
import com.sarfaraj.foodorderingapp.core.data.repository.BaseRepo
import javax.inject.Inject

class RepoImpl @Inject constructor(private val apiService: ApiService): BaseRepo, ApiCallHelper {
    override suspend fun getPizza(): NetworkResult<PizzaResponse> {
        return handleApiCall { apiService.getPizza() }
    }

    override suspend fun getJuice(): NetworkResult<JuiceResponse> {
        return handleApiCall { apiService.getJuice() }
    }
}
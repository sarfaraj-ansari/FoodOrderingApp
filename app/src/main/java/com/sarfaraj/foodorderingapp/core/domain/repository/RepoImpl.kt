package com.sarfaraj.foodorderingapp.core.domain.repository

import com.sarfaraj.foodorderingapp.common.ApiCallHelper
import com.sarfaraj.foodorderingapp.common.NetworkResult
import com.sarfaraj.foodorderingapp.core.data.network.ApiService
import com.sarfaraj.foodorderingapp.core.data.repository.BaseRepo
import com.sarfaraj.foodorderingapp.core.domain.model.JuiceModel
import com.sarfaraj.foodorderingapp.core.domain.model.PizzaModel
import javax.inject.Inject

class RepoImpl @Inject constructor(private val apiService: ApiService): BaseRepo, ApiCallHelper {
    override suspend fun getPizza(): NetworkResult<PizzaModel> {
        return handleApiCall { apiService.getPizza() }
    }

    override suspend fun getJuice(): NetworkResult<JuiceModel> {
        return handleApiCall { apiService.getJuice() }
    }
}
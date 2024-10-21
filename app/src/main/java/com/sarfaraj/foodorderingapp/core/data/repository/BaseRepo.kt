package com.sarfaraj.foodorderingapp.core.data.repository

import com.sarfaraj.foodorderingapp.common.NetworkResult
import com.sarfaraj.foodorderingapp.core.domain.model.JuiceModel
import com.sarfaraj.foodorderingapp.core.domain.model.PizzaModel

interface BaseRepo {

    suspend fun getPizza(): NetworkResult<PizzaModel>

    suspend fun getJuice(): NetworkResult<JuiceModel>
}
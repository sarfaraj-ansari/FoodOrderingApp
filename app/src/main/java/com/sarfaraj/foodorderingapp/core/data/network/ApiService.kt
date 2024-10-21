package com.sarfaraj.foodorderingapp.core.data.network


import com.sarfaraj.foodorderingapp.core.domain.model.JuiceModel
import com.sarfaraj.foodorderingapp.core.domain.model.PizzaModel
import retrofit2.Response

interface ApiService {
    suspend fun getPizza(): Response<PizzaModel>

    suspend fun getJuice(): Response<JuiceModel>
}
package com.sarfaraj.foodorderingapp.core.data.network


import com.sarfaraj.foodorderingapp.app.Constants
import com.sarfaraj.foodorderingapp.core.domain.model.MenuListModel
import com.sarfaraj.foodorderingapp.core.domain.model.RestaurantModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET(Constants.EndPoints.RESTAURANTS)
    suspend fun getRestaurants(): Response<RestaurantModel>

    @GET("${Constants.EndPoints.RESTAURANTS}/{restaurantId}/menu")
    suspend fun getMenu(@Path("restaurantId") restaurantId: Int): Response<MenuListModel>
}
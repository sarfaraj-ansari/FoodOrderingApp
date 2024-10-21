package com.sarfaraj.foodorderingapp.core.domain.repository

import com.sarfaraj.foodorderingapp.common.ApiCallHelper
import com.sarfaraj.foodorderingapp.common.NetworkResult
import com.sarfaraj.foodorderingapp.core.data.network.ApiService
import com.sarfaraj.foodorderingapp.core.data.repository.BaseRepo
import com.sarfaraj.foodorderingapp.core.domain.model.MenuListModel
import com.sarfaraj.foodorderingapp.core.domain.model.RestaurantModel
import javax.inject.Inject

class RepoImpl @Inject constructor(private val apiService: ApiService): BaseRepo, ApiCallHelper {
    override suspend fun getRestaurants(): NetworkResult<RestaurantModel> {
        return handleApiCall { apiService.getRestaurants() }
    }

    override suspend fun getMenu(restaurantId: Int): NetworkResult<MenuListModel> {
        return handleApiCall { apiService.getMenu(restaurantId) }
    }
}
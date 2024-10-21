package com.sarfaraj.foodorderingapp.core.data.repository

import com.sarfaraj.foodorderingapp.common.NetworkResult
import com.sarfaraj.foodorderingapp.core.domain.model.MenuListModel
import com.sarfaraj.foodorderingapp.core.domain.model.RestaurantModel

interface BaseRepo {

    suspend fun getRestaurants(): NetworkResult<RestaurantModel>

    suspend fun getMenu(restaurantId: Int): NetworkResult<MenuListModel>
}
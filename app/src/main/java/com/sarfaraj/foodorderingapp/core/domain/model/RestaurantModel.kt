package com.sarfaraj.foodorderingapp.core.domain.model

class RestaurantModel : ArrayList<RestaurantModel.RestaurantModelItem>() {
    data class RestaurantModelItem(
        val address1: String,
        val address2: String,
        val id: Int,
        val latitude: Double,
        val longitude: Double,
        val name: String
    )
}
package com.sarfaraj.foodorderingapp.core.domain.model

class MenuListModel : ArrayList<MenuListModel.MenuListModelItem>(){
    data class MenuListModelItem(
        val category: String,
        val id: Int,
        val name: String,
        val price: Int,
        val rank: Int,
        val topping: List<String>
    )
}
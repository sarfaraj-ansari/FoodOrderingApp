package com.sarfaraj.foodorderingapp.core.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.sarfaraj.foodorderingapp.core.domain.model.Common
import com.sarfaraj.foodorderingapp.databinding.ItemRestaurantAdapterBinding

class AdapterRestaurant(private val foodList: List<Common>) :
    Adapter<AdapterRestaurant.FoodHolder>() {
    inner class FoodHolder(private val item: ItemRestaurantAdapterBinding) : ViewHolder(item.root) {
        fun binViews(common: Common) {
            item.tvFood.text = common.name
            item.tvId.text = common.id
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodHolder {
        val item =
            ItemRestaurantAdapterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FoodHolder(item)
    }

    override fun getItemCount() = foodList.size

    override fun onBindViewHolder(holder: FoodHolder, position: Int) {
        holder.binViews(foodList[position])
    }
}
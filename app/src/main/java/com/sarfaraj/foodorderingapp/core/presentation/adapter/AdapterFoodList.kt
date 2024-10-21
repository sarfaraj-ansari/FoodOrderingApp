package com.sarfaraj.foodorderingapp.core.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.sarfaraj.foodorderingapp.databinding.ItemFoodAdapterBinding

class AdapterFoodList(private val foodList: List<String>) : Adapter<AdapterFoodList.FoodHolder>() {
    inner class FoodHolder(item: ItemFoodAdapterBinding) : ViewHolder(item.root) {
        fun binViews(food: String) {

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodHolder {
        val item =
            ItemFoodAdapterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FoodHolder(item)
    }

    override fun getItemCount() = foodList.size

    override fun onBindViewHolder(holder: FoodHolder, position: Int) {
        holder.binViews(foodList[position])
    }
}
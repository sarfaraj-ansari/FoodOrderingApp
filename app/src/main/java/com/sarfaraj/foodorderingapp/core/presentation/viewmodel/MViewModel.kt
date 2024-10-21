package com.sarfaraj.foodorderingapp.core.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sarfaraj.foodorderingapp.common.NetworkResult
import com.sarfaraj.foodorderingapp.core.domain.model.MenuListModel
import com.sarfaraj.foodorderingapp.core.domain.model.RestaurantModel
import com.sarfaraj.foodorderingapp.core.domain.repository.RepoImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MViewModel @Inject constructor(private val repoImpl: RepoImpl) : ViewModel() {
    private val _restaurants = MutableLiveData<NetworkResult<RestaurantModel>>()
    val restaurants: LiveData<NetworkResult<RestaurantModel>> = _restaurants

    private val _juice = MutableLiveData<NetworkResult<MenuListModel>>()
    val juice: LiveData<NetworkResult<MenuListModel>> = _juice

    fun getRestaurants() {
        viewModelScope.launch {
            _restaurants.postValue(NetworkResult.Loading)
            _restaurants.postValue(repoImpl.getRestaurants())
        }
    }

    fun getMenu(restaurantId: Int) {
        viewModelScope.launch {
            _juice.postValue(NetworkResult.Loading)
            _juice.postValue(repoImpl.getMenu(restaurantId))
        }
    }
}
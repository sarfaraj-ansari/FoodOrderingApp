package com.sarfaraj.foodorderingapp.core.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sarfaraj.foodorderingapp.common.NetworkResult
import com.sarfaraj.foodorderingapp.core.data.network.dto.JuiceResponse
import com.sarfaraj.foodorderingapp.core.data.network.dto.PizzaResponse
import com.sarfaraj.foodorderingapp.core.domain.repository.RepoImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MViewModel @Inject constructor(private val repoImpl: RepoImpl) : ViewModel() {
    private val _pizza = MutableLiveData<NetworkResult<PizzaResponse>>()
    val pizza: LiveData<NetworkResult<PizzaResponse>> = _pizza

    private val _juice = MutableLiveData<NetworkResult<JuiceResponse>>()
    val juice: LiveData<NetworkResult<JuiceResponse>> = _juice

    fun getPizza() {
        viewModelScope.launch {
            _pizza.postValue(NetworkResult.Loading)
            _pizza.postValue(repoImpl.getPizza())
        }
    }

    fun getJuice() {
        viewModelScope.launch {
            _juice.postValue(NetworkResult.Loading)
            _juice.postValue(repoImpl.getJuice())
        }
    }
}
package com.sarfaraj.foodorderingapp.core.presentation.activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.sarfaraj.foodorderingapp.common.NetworkResult
import com.sarfaraj.foodorderingapp.core.data.network.dto.JuiceResponse
import com.sarfaraj.foodorderingapp.core.data.network.dto.PizzaResponse
import com.sarfaraj.foodorderingapp.core.presentation.adapter.AdapterFoodList
import com.sarfaraj.foodorderingapp.core.presentation.viewmodel.MViewModel
import com.sarfaraj.foodorderingapp.databinding.ActivityMainBinding
import dagger.hilt.EntryPoint

@EntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var mAdapter: AdapterFoodList? = null
    private val listOfFood: ArrayList<String> by lazy { ArrayList() }
    private val viewModel by viewModels<MViewModel>()
    private lateinit var pizzaObserver: Observer<NetworkResult<PizzaResponse>>
    private lateinit var juiceObserver: Observer<NetworkResult<JuiceResponse>>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()
        onClicks()
        observers()

    }

    private fun observers() {
        
        pizzaObserver = Observer {

        }

        juiceObserver = Observer {

        }

        viewModel.pizza.observe(this, pizzaObserver)
        viewModel.juice.observe(this, juiceObserver)
    }

    private fun init() {
        mAdapter = AdapterFoodList(listOfFood)
        binding.recViewFoodList.adapter = mAdapter
    }

    private fun onClicks() {
        binding.apply {
            btGetPizza.setOnClickListener { viewModel.getPizza() }
            btGetJuice.setOnClickListener { viewModel.getJuice() }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.pizza.removeObserver(pizzaObserver)
        viewModel.juice.removeObserver(juiceObserver)
    }
}
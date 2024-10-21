package com.sarfaraj.foodorderingapp.core.presentation.activity

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.sarfaraj.foodorderingapp.common.NetworkResult
import com.sarfaraj.foodorderingapp.core.domain.model.JuiceModel
import com.sarfaraj.foodorderingapp.core.domain.model.PizzaModel
import com.sarfaraj.foodorderingapp.core.presentation.adapter.AdapterFoodList
import com.sarfaraj.foodorderingapp.core.presentation.viewmodel.MViewModel
import com.sarfaraj.foodorderingapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var mAdapter: AdapterFoodList? = null
    private val listOfFood: ArrayList<String> by lazy { ArrayList() }
    private val viewModel by viewModels<MViewModel>()
    private lateinit var pizzaObserver: Observer<NetworkResult<PizzaModel>>
    private lateinit var juiceObserver: Observer<NetworkResult<JuiceModel>>

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
            when(it) {
                is NetworkResult.Loading -> binding.progress.visibility = View.VISIBLE
                is NetworkResult.Success -> {
                    binding.progress.visibility = View.GONE
                }
                is NetworkResult.Failure -> binding.progress.visibility = View.GONE
            }
        }

        juiceObserver = Observer {
            when(it) {
                is NetworkResult.Loading -> binding.progress.visibility = View.VISIBLE
                is NetworkResult.Success -> {
                    binding.progress.visibility = View.GONE
                }
                is NetworkResult.Failure -> binding.progress.visibility = View.GONE
            }
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
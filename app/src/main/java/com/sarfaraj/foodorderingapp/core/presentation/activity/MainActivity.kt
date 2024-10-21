package com.sarfaraj.foodorderingapp.core.presentation.activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.sarfaraj.foodorderingapp.common.NetworkResult
import com.sarfaraj.foodorderingapp.core.domain.model.Common
import com.sarfaraj.foodorderingapp.core.domain.model.MenuListModel
import com.sarfaraj.foodorderingapp.core.domain.model.RestaurantModel
import com.sarfaraj.foodorderingapp.core.presentation.adapter.AdapterRestaurant
import com.sarfaraj.foodorderingapp.core.presentation.viewmodel.MViewModel
import com.sarfaraj.foodorderingapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var mAdapter: AdapterRestaurant? = null
    private val commonList: ArrayList<Common> by lazy { ArrayList() }
    private val viewModel by viewModels<MViewModel>()
    private lateinit var restaurantsObserver: Observer<NetworkResult<RestaurantModel>>
    private lateinit var menuListObserver: Observer<NetworkResult<MenuListModel>>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()
        onClicks()
        observers()

    }

    @SuppressLint("NotifyDataSetChanged")
    private fun observers() {

        restaurantsObserver = Observer {
            when (it) {
                is NetworkResult.Loading -> binding.progress.visibility = View.VISIBLE
                is NetworkResult.Success -> {
                    binding.progress.visibility = View.GONE
                    commonList.clear()
                    it.data.forEach { data ->
                        commonList.add(
                            Common(
                                "Restaurant Id: ${data.id}",
                                "Restaurant Name: ${data.name}"
                            )
                        )
                    }
                    mAdapter?.notifyDataSetChanged()
                }

                is NetworkResult.Failure -> binding.progress.visibility = View.GONE
            }
        }

        menuListObserver = Observer {
            when (it) {
                is NetworkResult.Loading -> binding.progress.visibility = View.VISIBLE
                is NetworkResult.Success -> {
                    binding.progress.visibility = View.GONE
                    commonList.clear()
                    it.data.forEach { data ->
                        commonList.add(
                            Common(
                                "Menu Id: ${data.id}",
                                "Menu Name: ${data.name}"
                            )
                        )
                    }
                    mAdapter?.notifyDataSetChanged()
                }

                is NetworkResult.Failure -> binding.progress.visibility = View.GONE
            }
        }

        viewModel.restaurants.observe(this, restaurantsObserver)
        viewModel.juice.observe(this, menuListObserver)
    }

    private fun init() {
        mAdapter = AdapterRestaurant(commonList)
        binding.recViewFoodList.adapter = mAdapter
    }

    private fun onClicks() {
        binding.apply {
            btGetRestaurant.setOnClickListener { viewModel.getRestaurants() }
            btGetMenu.setOnClickListener { viewModel.getMenu(2) }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.restaurants.removeObserver(restaurantsObserver)
        viewModel.juice.removeObserver(menuListObserver)
    }
}
package com.example.mvvmretrofitweather.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmretrofitweather.databinding.ActivityMainBinding
import com.example.mvvmretrofitweather.model.data.WeatherResponse
import com.example.mvvmretrofitweather.viewmodel.WeatherViewModel

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var weatherViewModel: WeatherViewModel
    lateinit var adapter: WeatherAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        weatherViewModel = ViewModelProvider(this)[WeatherViewModel::class.java]
        setContentView(binding.root)

        binding.fabAdd.setOnClickListener {
            weatherViewModel.searchWeather(binding.etCity.text.toString())
        }

        setupObservers()
    }

    private fun setupObservers() {
        val weatherList = mutableListOf<WeatherResponse>()
        weatherViewModel.weatherLiveData.observe(this){
            weatherList.add(it)
            binding.apply {
                adapter = WeatherAdapter(weatherList)
                binding.vpCities.adapter = adapter
            }
        }

        weatherViewModel.error.observe(this){
            Toast.makeText(this, it, Toast.LENGTH_LONG).show()
        }
    }
}
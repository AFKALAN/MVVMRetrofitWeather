package com.example.mvvmretrofitweather.view

import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmretrofitweather.databinding.ViewHolderWeatherBinding
import com.example.mvvmretrofitweather.model.data.WeatherResponse

class WeatherViewHolder(private val binding: ViewHolderWeatherBinding): RecyclerView.ViewHolder(binding.root) {
    fun setData(weather: WeatherResponse){
        binding.city = weather
    }
}
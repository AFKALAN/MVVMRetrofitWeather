package com.example.mvvmretrofitweather.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmretrofitweather.databinding.ViewHolderWeatherBinding
import com.example.mvvmretrofitweather.model.data.WeatherResponse

class WeatherAdapter(private val cityList: List<WeatherResponse>): RecyclerView.Adapter<WeatherViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ViewHolderWeatherBinding.inflate(layoutInflater, parent, false)
        return WeatherViewHolder(binding)
    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        holder.setData(cityList[position])
    }

    override fun getItemCount() = cityList.size
}
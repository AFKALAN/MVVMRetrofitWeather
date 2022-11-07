package com.example.mvvmretrofitweather.model

import com.example.mvvmretrofitweather.model.data.WeatherResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("weather")
    fun getWeather(
        @Query("q") city: String,
        @Query("appId") apiKey: String,
        @Query("units") units: String
    ): Call<WeatherResponse>
}
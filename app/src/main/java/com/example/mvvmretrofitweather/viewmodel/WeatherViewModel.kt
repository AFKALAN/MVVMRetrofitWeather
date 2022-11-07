package com.example.mvvmretrofitweather.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmretrofitweather.model.ApiClient
import com.example.mvvmretrofitweather.model.data.Constants.TOKEN
import com.example.mvvmretrofitweather.model.data.WeatherResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WeatherViewModel: ViewModel() {
    val weatherLiveData = MutableLiveData<WeatherResponse>()
    val error = MutableLiveData<String>()

    fun searchWeather(city: String){
        val city = city
        val units = "imperial" //change to "metric" for celsius

        val call = ApiClient.apiService.getWeather(city, TOKEN, units)
        call.enqueue(object : Callback<WeatherResponse>{
            override fun onResponse(
                call: Call<WeatherResponse>,
                response: Response<WeatherResponse>
            ) {
                if (response.isSuccessful){
                    weatherLiveData.postValue(response.body())
                }else{
                    error.value = "Error retrieving city"
                }
            }

            override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {
                error.value = t.message
                t.printStackTrace()
            }

        })
    }
}
package com.example.rma_project.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rma_project.data.api.RetrofitService
import com.example.rma_project.data.model.City
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CityViewModel : ViewModel() {
    private val retrofitService: RetrofitService = RetrofitService.create()

    private val _cities = MutableStateFlow<List<City>>(emptyList())
    val cities: StateFlow<List<City>> = _cities

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage

    fun searchCities(namePrefix: String) {
        viewModelScope.launch {
            try {
                val response = retrofitService.getCities(namePrefix)
                Log.d("API_RESPONSE", response.data.toString())
                val filteredCities = response.data
                    .filter { it.population > 0 }
                    .sortedByDescending { it.population }
                    .take(10) // Take the top 10 cities by population
                _cities.value = filteredCities
                _errorMessage.value = if (filteredCities.isEmpty()) {
                    "No cities found with the name $namePrefix"
                } else {
                    null
                }
                Log.d("gradovi", filteredCities.toString())
            } catch (e: Exception) {
                Log.d("CityViewModel", "Error fetching cities: ${e.message}")
                _errorMessage.value = "Error fetching cities: ${e.message}"
            }
        }
    }
}


package com.example.rma_project.data.model

data class CitiesResponse (
    val data: List<City>
)

data class City(
    var id : String,
    var name : String,
    val country : String,
    val population: Int
)

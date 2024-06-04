package com.example.rma_project.data.model

data class Comment(
    var userId : String = "",
    var dateCreated : Long = 0L,
    var cityName : String = "",
    var createdBy: String = "",
    var text : String = ""
)
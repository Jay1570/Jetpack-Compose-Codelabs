package com.example.cupcake.data

data class OrderUiState(
    val quantity: Int = 0,
    val flavour:String = "",
    val date: String = "",
    val price: String = "",
    val pickUpOptions: List<String> = listOf()
)
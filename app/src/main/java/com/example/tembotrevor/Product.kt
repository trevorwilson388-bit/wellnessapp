package com.example.tembotrevor

data class Product(
    val id: Int,
    val name: String,
    val description: String,
    val price: Double,
    val imageResId: Int = 0 // Placeholder - replace with actual drawable resource IDs
)
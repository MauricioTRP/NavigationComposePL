package com.example.navigationlab.data

/**
 * Hardcoded sample data
 */

typealias Url  = String

data class Product (
    val id: Int,
    val name: String,
    val description: String?,
    val image: Url?,
    val price: Double
)


package com.example.navigationlab

import kotlinx.serialization.Serializable



sealed class Destinations {
    @Serializable
    object Home : Destinations()

    @Serializable
    class ProductDetails(val productId: Int) : Destinations()
}

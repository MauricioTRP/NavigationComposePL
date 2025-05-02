package com.example.navigationlab

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector
import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable



sealed class Destinations {
    @Serializable
    object Home : Destinations()

    @Serializable
    data class ProductDetails(val productId: Int) : Destinations()
}

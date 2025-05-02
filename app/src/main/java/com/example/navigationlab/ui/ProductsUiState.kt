package com.example.navigationlab.ui

import com.example.navigationlab.data.Product

data class ProductsUiState (
    val loading: Boolean = false,
    val products: List<Product> = emptyList(),
    val error: String? = null
)
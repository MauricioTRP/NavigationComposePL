package com.example.navigationlab.ui

import com.example.navigationlab.data.Product

data class ProductUiState(
    val loading: Boolean = false,
    val product: Product? = null,
    val error: String? = null
)
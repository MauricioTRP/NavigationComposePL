package com.example.navigationlab.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.example.navigationlab.data.Product
import com.example.navigationlab.viewmodel.ProductsViewModel
import androidx.compose.runtime.getValue
import com.example.navigationlab.ui.components.ProductCard

@Composable
fun ProductDetailsScreen(
    viewModel: ProductsViewModel,
    productId: Int
) {
    val productUiState by viewModel.productUiState.collectAsState()

    LaunchedEffect (productId) {
        viewModel.loadProduct(productId)
    }


    if (productUiState.product != null) {
        ProductDetailsContent(product = productUiState.product!!)
    }
}

@Composable
fun ProductDetailsContent(
    product: Product,
    modifier: Modifier = Modifier
) {
    ProductCard(product, modifier = modifier) {  }
}
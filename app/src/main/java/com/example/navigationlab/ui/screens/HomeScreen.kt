package com.example.navigationlab.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.example.navigationlab.data.Product
import com.example.navigationlab.ui.components.ProductsList
import com.example.navigationlab.viewmodel.ProductsViewModel
import androidx.compose.runtime.getValue

@Composable
fun HomeScreen(
    productsViewModel: ProductsViewModel,
    onProductClick: (Product) -> Unit
) {
    val productsUiState by productsViewModel.productsUiState.collectAsState()

    Scaffold { innerPadding ->
        Column (modifier = Modifier.padding(innerPadding)) {
            ProductsList(
                products = productsUiState.products,
                onProductClick
            )
        }
    }
}

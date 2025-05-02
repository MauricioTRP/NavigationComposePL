package com.example.navigationlab.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.navigationlab.data.repository.ProductsRepository
import com.example.navigationlab.ui.ProductUiState
import com.example.navigationlab.ui.ProductsUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductsViewModel @Inject constructor(
    private val productsRepository: ProductsRepository
) : ViewModel() {
    private val _productsUiState = MutableStateFlow(ProductsUiState())
    private val _product = MutableStateFlow(ProductUiState())
    val productsUiState = _productsUiState.asStateFlow()
    val productUiState = _product.asStateFlow()

    init {
        loadProducts()
    }

    fun loadProducts() {
        _productsUiState.value = ProductsUiState(loading = true)
        viewModelScope.launch {
            _productsUiState.update { it.copy(
                loading = false,
                products = productsRepository.getProducts()
            )}
        }
    }

    fun loadProduct(productId: Int) {
        _product.value = ProductUiState(loading = true)
        viewModelScope.launch {
            _product.update {
                it.copy(
                    loading = false,
                    product = productsRepository.getProductById(productId)
                )
            }
        }
    }
}
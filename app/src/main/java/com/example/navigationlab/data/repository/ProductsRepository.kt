package com.example.navigationlab.data.repository

import com.example.navigationlab.data.Product

interface ProductsRepository {
    suspend fun getProducts(): List<Product>
    suspend fun getProductById(productId: Int): Product?
}
package com.example.navigationlab.data.local

import com.example.navigationlab.data.Product

interface LocalStoreDataProvider {
    fun getProductById(productId: Int): Product?
    fun getProducts() : List<Product>
}
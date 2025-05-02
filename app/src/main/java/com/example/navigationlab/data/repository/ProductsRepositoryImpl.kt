package com.example.navigationlab.data.repository

import com.example.navigationlab.data.Product
import com.example.navigationlab.data.local.LocalStoreDataProvider
import javax.inject.Inject

class ProductsRepositoryImpl @Inject constructor (
    private val localDataProvider : LocalStoreDataProvider,
    // a remote data provider
) : ProductsRepository {
    override suspend fun getProducts(): List<Product> {
        return localDataProvider.getProducts()
    }

    override suspend fun getProductById(productId: Int): Product? {
        return localDataProvider.getProductById(productId)
    }
}
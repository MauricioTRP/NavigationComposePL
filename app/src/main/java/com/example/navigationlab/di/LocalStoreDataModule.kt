package com.example.navigationlab.di

import com.example.navigationlab.data.local.LocalStoreDataProvider
import com.example.navigationlab.data.local.LocalStoreDataProviderImpl
import com.example.navigationlab.data.repository.ProductsRepository
import com.example.navigationlab.data.repository.ProductsRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class LocalStoreDataModule {
    @Binds
    @Singleton
    abstract fun bindLocalStoreDataProvider(
        localStoreDataProviderImpl: LocalStoreDataProviderImpl
    ): LocalStoreDataProvider
}

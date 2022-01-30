package com.android.cryptocurrency.di

import com.android.cryptocurrency.data.datasource.CoinRemoteDatasource
import com.android.cryptocurrency.data.repository.CoinRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {

    @Provides
    @Singleton
    fun provideCoinRepository(coinRemoteDatasource: CoinRemoteDatasource): CoinRepositoryImpl {
        return CoinRepositoryImpl(coinRemoteDatasource)
    }
}
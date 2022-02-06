package com.android.cryptocurrency.di

import com.android.cryptocurrency.data.repository.CoinRepositoryImpl
import com.android.cryptocurrency.framework.datasource.remoteDatasource.CoinRemoteDatasourceImpl
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
    fun provideCoinRepository(coinRemoteDatasourceImpl: CoinRemoteDatasourceImpl): CoinRepositoryImpl {
        return CoinRepositoryImpl(coinRemoteDatasourceImpl)
    }
}
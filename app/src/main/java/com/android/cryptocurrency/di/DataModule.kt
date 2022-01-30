package com.android.cryptocurrency.di

import com.android.cryptocurrency.framework.datasource.CoinPaprikaApi
import com.android.cryptocurrency.framework.datasource.remoteDatasource.CoinRemoteDatasourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideRemoteDataSource(coinApi: CoinPaprikaApi): CoinRemoteDatasourceImpl {
        return CoinRemoteDatasourceImpl(coinApi)
    }
}
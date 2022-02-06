package com.android.cryptocurrency.di

import com.android.cryptocurrency.data.repository.CoinRepositoryImpl
import com.android.cryptocurrency.domain.usecase.coin.getCoin.GetCoinUseCase
import com.android.cryptocurrency.domain.usecase.coin.getCoins.GetCoinsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideGetCoinsUseCase(coinRepositoryImpl: CoinRepositoryImpl): GetCoinsUseCase {
        return GetCoinsUseCase(coinRepositoryImpl)
    }

    @Provides
    @Singleton
    fun provideGetCoinUseCase(coinRepositoryImpl: CoinRepositoryImpl): GetCoinUseCase {
        return GetCoinUseCase(coinRepositoryImpl)
    }

}
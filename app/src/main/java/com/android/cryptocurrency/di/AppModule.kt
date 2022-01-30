package com.android.cryptocurrency.di

import com.android.cryptocurrency.domain.repository.CoinRepository
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
    fun provideGetCoinsUseCase(coinRepository: CoinRepository): GetCoinsUseCase {
        return GetCoinsUseCase(coinRepository)
    }

    @Provides
    @Singleton
    fun provideGetCoinUseCase(coinRepository: CoinRepository): GetCoinUseCase {
        return GetCoinUseCase(coinRepository)
    }

}
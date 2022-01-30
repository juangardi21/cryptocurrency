package com.android.cryptocurrency.domain.repository

import com.android.cryptocurrency.domain.model.Coin
import com.android.cryptocurrency.domain.model.CoinDetail

interface CoinRepository {

    suspend fun getCoins(): List<Coin>

    suspend fun getCoinById(coinId: String): CoinDetail
}
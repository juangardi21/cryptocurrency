package com.android.cryptocurrency.data.datasource

import com.android.cryptocurrency.domain.model.Coin
import com.android.cryptocurrency.domain.model.CoinDetail

interface CoinRemoteDatasource {

    suspend fun getCoins(): List<Coin>

    suspend fun getCoin(coinId: String): CoinDetail
}
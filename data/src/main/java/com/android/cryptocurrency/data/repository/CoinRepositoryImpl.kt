package com.android.cryptocurrency.data.repository

import com.android.cryptocurrency.data.datasource.CoinRemoteDatasource
import com.android.cryptocurrency.domain.model.Coin
import com.android.cryptocurrency.domain.model.CoinDetail
import com.android.cryptocurrency.domain.repository.CoinRepository

class CoinRepositoryImpl(
    private val datasource: CoinRemoteDatasource,
) : CoinRepository {
    override suspend fun getCoins(): List<Coin> {
        return datasource.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetail {
        return datasource.getCoin(coinId)
    }
}
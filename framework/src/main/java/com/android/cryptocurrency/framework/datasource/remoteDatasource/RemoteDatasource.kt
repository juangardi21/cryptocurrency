package com.android.cryptocurrency.framework.datasource.remoteDatasource

import com.android.cryptocurrency.data.datasource.CoinRemoteDatasource
import com.android.cryptocurrency.domain.model.Coin
import com.android.cryptocurrency.domain.model.CoinDetail
import com.android.cryptocurrency.framework.datasource.CoinPaprikaApi
import com.android.cryptocurrency.framework.datasource.dto.toCoin
import com.android.cryptocurrency.framework.datasource.dto.toCoinDetail

class CoinRemoteDatasourceImpl(
    private val api: CoinPaprikaApi,
): CoinRemoteDatasource {

    override suspend fun getCoins(): List<Coin> {
        return api.getCoins().map { it.toCoin() }
    }

    override suspend fun getCoin(coinId: String): CoinDetail {
        return api.getCoinById(coinId).toCoinDetail()
    }
}
package com.android.cryptocurrency.framework.datasource

import com.android.cryptocurrency.framework.datasource.dto.CoinDetailDto
import com.android.cryptocurrency.framework.datasource.dto.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaApi {

    @GET(GET_COINS)
    suspend fun getCoins(): List<CoinDto>

    @GET(GET_COIN)
    suspend fun getCoinById(@Path("coinId") coinId: String): CoinDetailDto


    companion object {
        private const val GET_COINS = "v1/coins"
        private const val GET_COIN = "v1/coins/{coinId}"
    }
}
package com.android.cryptocurrency.domain.usecase.coin.getCoin

import com.android.cryptocurrency.domain.model.CoinDetail
import com.android.cryptocurrency.domain.repository.CoinRepository
import com.android.cryptocurrency.domain.usecase.BaseUseCase

class GetCoinUseCase(
    private val repository: CoinRepository,
) : BaseUseCase<CoinDetail, GetCoinUseCase.Params>() {

    override suspend fun call(params: Params): CoinDetail = repository.getCoinById(params.coinId)

    data class Params(
        val coinId: String,
    )
}
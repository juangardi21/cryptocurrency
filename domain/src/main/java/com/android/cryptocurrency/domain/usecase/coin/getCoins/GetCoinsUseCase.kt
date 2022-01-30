package com.android.cryptocurrency.domain.usecase.coin.getCoins

import com.android.cryptocurrency.domain.model.Coin
import com.android.cryptocurrency.domain.repository.CoinRepository
import com.android.cryptocurrency.domain.usecase.BaseUseCase

class GetCoinsUseCase(
    private val repository: CoinRepository,
) : BaseUseCase<List<Coin>, Unit>() {

    override suspend fun call(params: Unit): List<Coin> = repository.getCoins()
}
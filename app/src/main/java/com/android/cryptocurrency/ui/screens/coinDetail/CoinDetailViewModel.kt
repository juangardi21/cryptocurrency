package com.android.cryptocurrency.ui.screens.coinDetail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.cryptocurrency.common.PARAM_COIN_ID
import com.android.cryptocurrency.domain.usecase.UseCaseResult
import com.android.cryptocurrency.domain.usecase.coin.getCoin.GetCoinUseCase
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class CoinDetailViewModel(
    private val getCoinUseCase: GetCoinUseCase,
    savedStateHandle: SavedStateHandle
): ViewModel() {

    private val _state = mutableStateOf(CoinDetailState())
    val state: State<CoinDetailState> = _state

    init {
        savedStateHandle.get<String>(PARAM_COIN_ID)?.let {
            getCoin(it)
        }
    }

    private fun getCoin(coinId: String) {
        _state.value = CoinDetailState(isLoading = true)
        viewModelScope.launch {
            getCoinUseCase.execute(GetCoinUseCase.Params(coinId)).onEach { result ->
                when(result) {
                    is UseCaseResult.Failure -> {
                        _state.value = CoinDetailState(
                            error = result.throwable.message!!
                        )
                    }
                    is UseCaseResult.Success -> {
                        _state.value = CoinDetailState(
                            coin = result.data
                        )
                    }
                }
            }
        }
    }


}
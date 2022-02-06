package com.android.cryptocurrency.ui.screens.coinList

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.cryptocurrency.domain.usecase.UseCaseResult
import com.android.cryptocurrency.domain.usecase.coin.getCoins.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val getCoinsUseCase: GetCoinsUseCase,
) : ViewModel() {

    private val _state = mutableStateOf(CoinListState())
    val state: State<CoinListState> = _state

    init {
        getCoins()
    }

    private fun getCoins() {
        _state.value = CoinListState(isLoading = true)
        viewModelScope.launch {
            getCoinsUseCase.execute(Unit).collect { result ->
                when (result) {
                    is UseCaseResult.Failure -> {
                        _state.value =
                            CoinListState(error = result.throwable.message ?: "Unknown error")
                    }
                    is UseCaseResult.Success -> {
                        _state.value = CoinListState(coins = result.data)
                    }
                }
            }
        }
    }
}
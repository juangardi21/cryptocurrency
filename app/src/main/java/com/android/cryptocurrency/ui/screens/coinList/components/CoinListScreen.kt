package com.android.cryptocurrency.ui.screens.coinList.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.android.cryptocurrency.domain.model.Coin
import com.android.cryptocurrency.ui.screens.coinList.CoinListState
import com.android.cryptocurrency.ui.screens.coinList.CoinListViewModel

@Composable
fun CoinListScreen(
    navigate: (Coin) -> Unit,
    viewModel: CoinListViewModel = hiltViewModel(),
) {
    val state = viewModel.state.value
    ScreenImpl(navigate, state)
}

@Composable
private fun ScreenImpl(
    navigate: (Coin) -> Unit,
    state: CoinListState
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(items = state.coins) { coin ->
                CoinListItem(
                    coin = coin,
                    onItemClick = {
                        navigate(it)
                    }
                )
            }
        }

        if (state.error.isNotBlank()) {
            Text(
                text = state.error,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
            )
        }
        if (state.isLoading) {
            CircularProgressIndicator()
        }
    }
}

@Preview
@Composable
fun Preview23() {
    val state = CoinListState(true)
    ScreenImpl(navigate = {}, state)
}
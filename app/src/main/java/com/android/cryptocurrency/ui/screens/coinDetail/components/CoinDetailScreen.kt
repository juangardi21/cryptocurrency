package com.android.cryptocurrency.ui.screens.coinDetail.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.android.cryptocurrency.domain.model.CoinDetail
import com.android.cryptocurrency.ui.screens.coinDetail.CoinDetailState
import com.android.cryptocurrency.ui.screens.coinDetail.CoinDetailViewModel
import com.google.accompanist.flowlayout.FlowRow

@Composable
fun CoinDetailScreen(
    viewModel: CoinDetailViewModel = hiltViewModel(),
) {
    val state = viewModel.state.value
    ScreenImpl(state)
}

@Composable
private fun ScreenImpl(
    state: CoinDetailState
) {
    Box(
        modifier = Modifier.fillMaxSize().padding(horizontal = 16.dp),
    ) {
        state.coin?.let { coin ->
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                item {
                    Spacer(Modifier.height(16.dp))
                    CoinNameAndDescription(coin)

                    Spacer(Modifier.height(16.dp))

                    Text(
                        text = coin.description,
                        style = MaterialTheme.typography.body2,
                    )

                    Spacer(Modifier.height(16.dp))

                    TagList(coin)

                    Spacer(Modifier.height(16.dp))

                    Text(
                        text = "Team members",
                        style = MaterialTheme.typography.h4,
                    )
                }

                items(coin.team) { teamMember ->
                    TeamListItem(teamMember = teamMember)
                    Divider()
                }
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

@Composable
private fun CoinNameAndDescription(coin: CoinDetail) {
    Row() {
        Text(
            text = "${coin.rank}. ${coin.name} ${coin.symbol}",
            modifier = Modifier.weight(8f),
            textAlign = TextAlign.Start,
            overflow = TextOverflow.Ellipsis,
            maxLines = 1,
            style = MaterialTheme.typography.h4,
        )

        Text(
            text = if (coin.isActive) "active" else "inactive",
            modifier = Modifier
                .align(CenterVertically)
                .weight(2f),
            textAlign = TextAlign.End,
            fontStyle = FontStyle.Italic,
            color = if (coin.isActive) Color.Green else Color.Red,
            style = MaterialTheme.typography.body2,
        )
    }

    Spacer(Modifier.height(16.dp))

    Text(
        text = coin.description,
        style = MaterialTheme.typography.body2,
    )
}

@Composable
private fun TagList(coin: CoinDetail) {
    Text(
        text = "Tags",
        style = MaterialTheme.typography.h4,
    )

    Spacer(Modifier.height(16.dp))

    FlowRow(
        mainAxisSpacing = 8.dp,
        crossAxisSpacing = 8.dp,
        modifier = Modifier.fillMaxWidth()
    ) {
        coin.tags.forEach { tag ->
            CoinTag(tag = tag)
        }
    }
}

@Preview
@Composable
fun CoinDetailScreenPreview() {
    val state = CoinDetailState()
    ScreenImpl(state)
}
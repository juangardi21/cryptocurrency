package com.android.cryptocurrency.ui.screens.coinList.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.cryptocurrency.domain.model.Coin

@Composable
fun CoinListItem(
    coin: Coin,
    onItemClick: (Coin) -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .clickable { onItemClick(coin) }
            .padding(horizontal = 16.dp, vertical = 24.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(
            text = "${coin.rank}. ${coin.name} ${coin.symbol}",
            textAlign = TextAlign.Start,
            overflow = TextOverflow.Ellipsis,
            maxLines = 1,
            color = MaterialTheme.colors.onSurface,
            style = MaterialTheme.typography.body1
        )

        Text(
            text = if (coin.isActive) "active" else "inactive",
            textAlign = TextAlign.End,
            color = if (coin.isActive) Color.Green else Color.Red,
            style = MaterialTheme.typography.body2,
            fontStyle = FontStyle.Italic,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CoinListItemPreview() {
    CoinListItem(
        coin = Coin(
            id = "id",
            isActive = false,
            name = "Bitcoin",
            rank = 1,
            symbol = "BTC"
        ),
        onItemClick = {})
}

@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun CoinListItemPreview2() {
    CoinListItem(
        coin = Coin(
            id = "id",
            isActive = true,
            name = "Bitcoin",
            rank = 1,
            symbol = "BTC"
        ),
        onItemClick = {})
}
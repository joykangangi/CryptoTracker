package com.plcoding.cryptotracker.crypto.presentation.coins_list.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.sp
import com.plcoding.cryptotracker.crypto.domain.Coin
import com.plcoding.cryptotracker.crypto.presentation.mappers.CoinMappers.toCoinUI
import com.plcoding.cryptotracker.crypto.presentation.models.CoinUI
import com.plcoding.cryptotracker.crypto.presentation.models.DisplayableNumber
import com.plcoding.cryptotracker.ui.theme.CryptoTrackerTheme
import com.plcoding.cryptotracker.ui.theme.largePadding
import com.plcoding.cryptotracker.ui.theme.mediumObject

@Composable
fun CoinListItem(
    coinUI: CoinUI,
    onItemClick: () -> Unit,
    modifier: Modifier = Modifier
) {

    val onListItemClick = remember {
        {
            onItemClick()
        }
    }

    Card(
        onClick = onListItemClick,
        content = {
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(largePadding()),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(largePadding()),
                content = {

                    Icon(
                        modifier = Modifier.size(mediumObject()),
                        imageVector = ImageVector.vectorResource(id = coinUI.iconRes),
                        contentDescription = coinUI.name,
                        tint = MaterialTheme.colorScheme.primary
                    )

                    ItemDetailColum(
                        modifier = Modifier.weight(0.5f),
                        abbreviationName = coinUI.symbol,
                        fullName = coinUI.name
                    )

                    ItemStatsColum(
                        priceUSD = "$ ${coinUI.priceUSD.formatted}",
                        priceChange = coinUI.changePercent24Hr
                    )

                }
            )
        }
    )
}

@Composable
private fun ItemDetailColum(
    abbreviationName: String,
    fullName: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceAround,
        content = {
            Text(
                text = abbreviationName,
                style = MaterialTheme.typography.headlineMedium,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = fullName,
                style = MaterialTheme.typography.labelMedium,
                fontSize = 14.sp,
                fontWeight = FontWeight.Light
            )
        }
    )
}

@Composable
private fun ItemStatsColum(
    priceUSD: String,
    priceChange: DisplayableNumber,
    modifier: Modifier = Modifier
) {

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.End,
        content = {
            Text(
                text = priceUSD,
                style = MaterialTheme.typography.headlineMedium,
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold
            )

            PriceChangeRow(priceChange = priceChange)
        }
    )

}


@PreviewLightDark
@Composable
private fun PreviewCoinListItem() = CryptoTrackerTheme {
    CoinListItem(
        coinUI = previewCoinUI.toCoinUI(),
        onItemClick = {  }
    )
}

internal val previewCoinUI = Coin(
    id = "1",
    rank = 2,
    name = "Bitcoin",
    symbol = "BTC",
    marketCapUSD =  0.0,
    changePercent24Hr = 0.0,
    priceUSD = 0.0,
)
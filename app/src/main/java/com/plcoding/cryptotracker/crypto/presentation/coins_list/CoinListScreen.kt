package com.plcoding.cryptotracker.crypto.presentation.coins_list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.plcoding.cryptotracker.crypto.presentation.coins_list.components.CoinListItem
import com.plcoding.cryptotracker.crypto.presentation.coins_list.components.previewCoinUI
import com.plcoding.cryptotracker.crypto.presentation.mappers.CoinMappers.toCoinUI
import com.plcoding.cryptotracker.crypto.presentation.models.CoinListState
import com.plcoding.cryptotracker.ui.theme.CryptoTrackerTheme
import com.plcoding.cryptotracker.ui.theme.largePadding
import com.plcoding.cryptotracker.ui.theme.mediumPadding

@Composable
fun CoinsListScreen(
    state: CoinListState,
    modifier: Modifier = Modifier
) {

    if (state.isLoading) {
        Box(
            modifier = modifier.fillMaxSize(),
            contentAlignment = Alignment.Center,
            content = {
                CircularProgressIndicator()
            }
        )
    } else {
        LazyColumn(
            modifier = modifier
                .fillMaxSize()
                .padding(largePadding()),
            verticalArrangement = Arrangement.spacedBy(mediumPadding()),
            content = {
                items(state.coins) { coinUI ->
                    CoinListItem(
                        modifier = Modifier.fillMaxWidth(),
                        coinUI = coinUI,
                        onItemClick = { }
                    )

                    HorizontalDivider()
                }

            }
        )
    }

}


@PreviewLightDark
@Composable
private fun PreviewCoinListScreen() = CryptoTrackerTheme {

    CoinsListScreen(
        state = CoinListState(
            coins = (1..10).map { previewCoinUI.toCoinUI().copy(id = it.toString()) }
        )
    )
}
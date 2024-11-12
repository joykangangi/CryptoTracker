package com.plcoding.cryptotracker.crypto.presentation.models

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable


@Immutable
@Stable
data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<CoinUI> = emptyList(),
    val selectedCoin: CoinUI? = null
)

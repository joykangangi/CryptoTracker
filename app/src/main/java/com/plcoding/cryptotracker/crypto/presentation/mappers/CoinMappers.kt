package com.plcoding.cryptotracker.crypto.presentation.mappers

import com.plcoding.cryptotracker.crypto.domain.Coin
import com.plcoding.cryptotracker.crypto.presentation.models.CoinUI
import com.plcoding.cryptotracker.crypto.presentation.models.DisplayableNumber
import com.plcoding.cryptotracker.util.getDrawableIdForCoin
import java.text.NumberFormat
import java.util.Locale

object CoinMappers {

    fun Coin.toCoinUI(): CoinUI {
        return CoinUI(
            id = id,
            name = name,
            symbol = symbol,
            rank = rank,
            priceUSD = priceUSD.toDisplayableNumber(),
            marketCapUSD = marketCapUSD.toDisplayableNumber(),
            iconRes = getDrawableIdForCoin(symbol),
            changePercent24Hr = changePercent24Hr.toDisplayableNumber()
        )
    }

    private fun Double.toDisplayableNumber(): DisplayableNumber {
        val formatter = NumberFormat.getNumberInstance(Locale.getDefault()).apply {
            minimumFractionDigits = 2
            maximumFractionDigits = 2
        }
        return DisplayableNumber(
            value = this,
            formatted = formatter.format(this)
        )
    }
}
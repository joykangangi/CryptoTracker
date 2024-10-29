package com.plcoding.cryptotracker.crypto.presentation.mappers

import com.plcoding.cryptotracker.crypto.domain.Coin
import com.plcoding.cryptotracker.crypto.presentation.models.CoinUI
import com.plcoding.cryptotracker.crypto.presentation.models.DisplayableNumber

object CoinMappers {

    fun Coin.toCoinUI(): CoinUI {
        return CoinUI(
            id = this.id,
            name = this.name,
            symbol = this.symbol,
            rank = this.rank,
            priceUSD = ,
            marketCapUSD = ,
            iconRes = ,
            changePercent24Hr =
        )
    }

    fun Double.toDisplayableNumber(): DisplayableNumber {


        return
    }
}
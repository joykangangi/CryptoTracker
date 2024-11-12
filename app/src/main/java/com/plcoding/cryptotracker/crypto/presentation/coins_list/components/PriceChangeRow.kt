package com.plcoding.cryptotracker.crypto.presentation.coins_list.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowUpward
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.sp
import com.plcoding.cryptotracker.crypto.presentation.models.DisplayableNumber
import com.plcoding.cryptotracker.ui.theme.CryptoTrackerTheme
import com.plcoding.cryptotracker.ui.theme.smallObject
import com.plcoding.cryptotracker.ui.theme.smallPadding

@Composable
fun PriceChangeRow(
    priceChange: DisplayableNumber,
    modifier: Modifier = Modifier
) {

    val isIncrease = priceChange.value > 0.0

    val bgColor =
        if (isIncrease) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.errorContainer

    val contentColor =
        if (isIncrease) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onErrorContainer

    val arrowDirection = if (isIncrease) 0f else 180f

    val formattedPrice = if (isIncrease) "+ ${priceChange.formatted} %" else "${priceChange.formatted} %"

    Row(
        modifier = modifier
            .clip(RoundedCornerShape(100f))
            .background(bgColor, RoundedCornerShape(100f))
            .padding(horizontal = smallPadding()),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        content = {
            Icon(
                modifier = Modifier
                    .rotate(arrowDirection)
                    .size(smallObject()),
                tint = contentColor,
                imageVector = Icons.Filled.ArrowUpward,
                contentDescription = Icons.Filled.ArrowUpward.name
            )

            Text(
                text = formattedPrice,
                color = contentColor,
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp
            )
            
        }
    )

}


@PreviewLightDark
@Composable
private fun PreviewPriceChangeRow() = CryptoTrackerTheme {
    Column {
        PriceChangeRow(
            priceChange = DisplayableNumber(
                value = 2.43,
                formatted = "2.43"
            )
        )

        PriceChangeRow(
            priceChange = DisplayableNumber(
                value = -5.43,
                formatted = "-2.43"
            )
        )
    }
}
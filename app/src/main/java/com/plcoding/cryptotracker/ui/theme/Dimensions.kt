package com.plcoding.cryptotracker.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.res.dimensionResource
import com.plcoding.cryptotracker.R

/**Padding: 16, 8,4 */
@ReadOnlyComposable
@Composable
fun largePadding() = dimensionResource(id = R.dimen.large_padding)

@ReadOnlyComposable
@Composable
fun mediumPadding() = dimensionResource(id = R.dimen.large_padding) / 2

@ReadOnlyComposable
@Composable
fun smallPadding() = dimensionResource(id = R.dimen.large_padding) / 4

/**Spacers: 20, 10,5 */
@ReadOnlyComposable
@Composable
fun largeSpacer() = dimensionResource(id = R.dimen.large_spacer)

@ReadOnlyComposable
@Composable
fun mediumSpacer() = dimensionResource(id = R.dimen.large_spacer) / 2

@ReadOnlyComposable
@Composable
fun smallSpacer() = dimensionResource(id = R.dimen.large_spacer) / 4


/**OBJECT: 200,100, 50, */
@ReadOnlyComposable
@Composable
fun largeObject() = dimensionResource(id = R.dimen.large_object) * 2

@ReadOnlyComposable
@Composable
fun mediumObject() = dimensionResource(id = R.dimen.large_object)

@ReadOnlyComposable
@Composable
fun smallObject() = mediumObject() / 5

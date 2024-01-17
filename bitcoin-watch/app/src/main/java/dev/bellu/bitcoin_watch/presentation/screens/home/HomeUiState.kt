package dev.bellu.bitcoin_watch.presentation.screens.home

data class HomeUiState(
    val bitcoinValue: Double = 0.0,
    val satoshiValue: Double = 0.0,
    val brlValue: Double = 0.0,
    val bitcoinAppreciationValue: Double = 0.0,
    val bitcoinDepreciationValue: Double = 0.0,
    val bitcoinAppreciationPercentage: Double = 0.0,
    val bitcoinDepreciationPercentage: Double = 0.0,
    val priceInput: Double = 0.0,
    val bitcoinCurrentConvert: Double = 0.0
)

package dev.bellu.unscramblegame.presentation.screens.home

data class HomeUiState(
    val index: Int = 0,
    val word: String = "",
    val scrambled: String = "",
    val score: Int = 0
)

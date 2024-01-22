package dev.bellu.flight_search.presentation.screens

import dev.bellu.flight_search.presentation.entity.FlightEntity

data class HomeUiState(
    val flights: MutableList<FlightEntity> = mutableListOf()
)

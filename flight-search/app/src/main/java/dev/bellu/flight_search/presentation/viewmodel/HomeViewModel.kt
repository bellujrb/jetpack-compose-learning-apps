package dev.bellu.flight_search.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.bellu.flight_search.data.database.FlightDatabase
import dev.bellu.flight_search.data.entity.AirportEntity
import dev.bellu.flight_search.presentation.entity.FlightEntity
import dev.bellu.flight_search.presentation.screens.HomeUiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlin.random.Random

class HomeViewModel(private val db: FlightDatabase) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    init {
        fetchDataFromDatabase()
    }

    private fun fetchDataFromDatabase() {
        viewModelScope.launch(Dispatchers.IO) {
            val data = db.FlightDao().getAllAirport()
            loadFlights(data)
        }
    }

    private fun loadFlights(data: List<AirportEntity>) {
        val flights = mutableListOf<FlightEntity>()
        for (i in 1..20) {

            val randomDepart = Random.nextInt(0, 33)

            if (i != randomDepart) {
                flights.add(
                    FlightEntity(
                        departName = data[i].name,
                        departCode = data[i].iataCode,
                        arriveName = data[randomDepart].name,
                        arriveCode = data[randomDepart].iataCode
                    )
                )

                if (i == 20) {
                    _uiState.value = _uiState.value.copy(
                        flights = flights
                    )
                }
            }
        }
    }

}
package dev.bellu.flight_search.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.bellu.flight_search.data.database.FlightDatabase
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class HomeViewModel(private val db: FlightDatabase): ViewModel() {

    fun fetchDataFromDatabase() {
        viewModelScope.launch(Dispatchers.IO) {
            val dbJson = db.FlightDao().getAllAirport()
            Log.e("DB", dbJson.toString())
        }
    }

}
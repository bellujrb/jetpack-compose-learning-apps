package dev.bellu.flight_search.data.contracts

import androidx.room.Dao
import androidx.room.Query
import dev.bellu.flight_search.data.entity.AirportEntity

@Dao
interface FlightDao{
    @Query("SELECT * FROM airport")
    fun getAllAirport(): List<AirportEntity>
}
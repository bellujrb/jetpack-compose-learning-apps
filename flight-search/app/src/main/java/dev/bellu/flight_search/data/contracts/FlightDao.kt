package dev.bellu.flight_search.data.contracts

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import dev.bellu.flight_search.data.entity.AirportEntity

@Dao
interface FlightDao{

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(airport: AirportEntity)
    @Query("SELECT * FROM airport")
    fun getAllAirport(): List<AirportEntity>
}
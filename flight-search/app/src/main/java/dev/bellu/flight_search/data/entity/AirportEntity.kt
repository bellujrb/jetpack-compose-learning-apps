package dev.bellu.flight_search.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "airport")
data class AirportEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int,

    @ColumnInfo(name = "iata_code")
    val iataCode: String,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "passangers")
    val passangers: Int
)
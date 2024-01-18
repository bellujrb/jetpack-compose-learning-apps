package dev.bellu.flight_search.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorite")
data class FavoriteEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int,

    @ColumnInfo(name = "departure_code")
    val departureCode: String,

    @ColumnInfo(name = "destination_code")
    val destinationCode: String
)
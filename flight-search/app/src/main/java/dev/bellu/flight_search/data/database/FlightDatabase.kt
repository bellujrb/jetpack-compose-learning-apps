package dev.bellu.flight_search.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import dev.bellu.flight_search.data.contracts.FlightDao
import dev.bellu.flight_search.data.entity.AirportEntity
import dev.bellu.flight_search.data.entity.FavoriteEntity

@Database(entities = [AirportEntity::class, FavoriteEntity::class], version = 1)
abstract class FlightDatabase: RoomDatabase(){
    abstract fun FlightDao(): FlightDao

    companion object{
        fun getDatabase(context: Context): FlightDatabase{
            return Room.databaseBuilder(
                name = "flight_search.db",
                klass = FlightDatabase::class.java,
                context = context
            )
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}
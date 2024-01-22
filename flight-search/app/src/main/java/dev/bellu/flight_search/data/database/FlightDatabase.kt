package dev.bellu.flight_search.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import dev.bellu.flight_search.data.contracts.FlightDao
import dev.bellu.flight_search.data.entity.AirportEntity
import dev.bellu.flight_search.data.entity.FavoriteEntity
import java.io.*

@Database(entities = [AirportEntity::class, FavoriteEntity::class], version = 1)
abstract class FlightDatabase : RoomDatabase() {
    abstract fun FlightDao(): FlightDao

    companion object {
        private const val DATABASE_NAME = "new_flight_search.db"
        fun getDatabase(context: Context): FlightDatabase {
            return Room.databaseBuilder(
                name = DATABASE_NAME,
                klass = FlightDatabase::class.java,
                context = context.applicationContext
            )
                .createFromAsset("flight_search.db")
                .build()
        }
    }
}
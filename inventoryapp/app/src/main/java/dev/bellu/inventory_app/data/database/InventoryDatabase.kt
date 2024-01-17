package dev.bellu.inventory_app.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import dev.bellu.inventory_app.data.entity.ItemEntity
import dev.bellu.inventory_app.data.contracts.ItemDao

@Database(entities = [ItemEntity::class], version = 1, exportSchema = false)
abstract class InventoryDatabase : RoomDatabase() {
    abstract fun itemDao(): ItemDao

    companion object {
        fun getDatabase(context: Context): InventoryDatabase {
            return Room.databaseBuilder(
                context,
                InventoryDatabase::class.java,
                "db_inventory"
            )
                .fallbackToDestructiveMigration()
                .build()
        }
    }

}


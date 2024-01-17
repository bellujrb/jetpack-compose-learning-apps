package dev.bellu.inventory_app

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import dev.bellu.inventory_app.data.database.InventoryDatabase
import dev.bellu.inventory_app.data.entity.ItemEntity
import dev.bellu.inventory_app.presentation.screens.HomeView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            HomeView()
        }
    }
}


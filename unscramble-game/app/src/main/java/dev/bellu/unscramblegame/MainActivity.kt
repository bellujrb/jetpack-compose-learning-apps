package dev.bellu.unscramblegame

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dev.bellu.unscramblegame.presentation.screens.home.HomeScreen
import dev.bellu.unscramblegame.presentation.screens.welcome.WelcomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            NavHost(navController = navController, startDestination = "welcome"){
                composable("welcome"){ WelcomeScreen(navController) }
                composable("home"){ HomeScreen() }
            }
        }
    }
}
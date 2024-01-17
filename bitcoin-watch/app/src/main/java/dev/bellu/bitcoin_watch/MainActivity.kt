package dev.bellu.bitcoin_watch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dev.bellu.bitcoin_watch.presentation.screens.home.HomeScreen
import dev.bellu.bitcoin_watch.presentation.screens.login.LoginScreen
import dev.bellu.bitcoin_watch.presentation.screens.register.RegisterScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            NavHost(navController = navController, startDestination = "home"){
                composable("login"){ LoginScreen(navController = navController)}
                composable("register") { RegisterScreen()}
                composable("home") { HomeScreen()}
            }
        }
    }
}

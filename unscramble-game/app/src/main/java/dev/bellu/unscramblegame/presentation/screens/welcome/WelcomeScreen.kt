package dev.bellu.unscramblegame.presentation.screens.welcome

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import dev.bellu.unscramblegame.presentation.theme.Colors
import dev.bellu.unscramblegame.presentation.theme.Typography
import dev.bellu.unscramblegame.presentation.theme.UnscrambleGameTheme
import kotlinx.coroutines.delay
import dev.bellu.unscramblegame.R


@Composable
fun WelcomeScreen(navController: NavController) {

    LaunchedEffect(key1 = true){
        delay(1000)
        navController.navigate("home")
    }

    UnscrambleGameTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Colors.primary),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = stringResource(R.string.app_name),
                style = Typography.displayMedium
            )
        }
    }
}
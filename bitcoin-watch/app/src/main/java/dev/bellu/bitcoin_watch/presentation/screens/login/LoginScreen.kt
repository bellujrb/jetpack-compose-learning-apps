package dev.bellu.bitcoin_watch.presentation.screens.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import dev.bellu.bitcoin_watch.R
import dev.bellu.bitcoin_watch.presentation.components.Button
import dev.bellu.bitcoin_watch.presentation.components.Input
import dev.bellu.bitcoin_watch.presentation.utils.Colors

@Composable
fun LoginScreen(viewModel: LoginViewModel = LoginViewModel(), navController: NavController){

    val uiState by viewModel.uiState.collectAsState()
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Colors.onPrimary
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = null
            )
            Column {
                Input(
                    label = "Your E-mail",
                    placeholder = "E-mail",
                    value = uiState.email,
                    onValueChange = {},
                    maxWidth = 0.8f
                )
                Spacer(modifier = Modifier.height(10.dp))
                Input(
                    label = "Your Password",
                    placeholder = "Password",
                    value = uiState.password,
                    onValueChange = {},
                    maxWidth = 0.8f
                )
                Spacer(modifier = Modifier.height(20.dp))
                Button(title = "Login", maxWidth = 0.8f, onClick = { navController.navigate("home")})
            }
        }
    }
}
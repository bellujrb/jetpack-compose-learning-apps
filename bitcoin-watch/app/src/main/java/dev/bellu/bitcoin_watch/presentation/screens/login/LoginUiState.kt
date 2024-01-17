package dev.bellu.bitcoin_watch.presentation.screens.login

data class LoginUiState(
    val email: String = "",
    val password: String = "",
    val isLogged: Boolean = false
)

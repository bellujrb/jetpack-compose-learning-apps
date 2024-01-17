package dev.bellu.bitcoin_watch.presentation.screens.register

data class RegisterUiState(
    val username: String,
    val email: String,
    val password: String,
    val confirmPassword: String,
    val token: String
)

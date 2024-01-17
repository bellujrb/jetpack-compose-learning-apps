package dev.bellu.bitcoin_watch.data.models

data class RegisterModel(
    val nickname: String,
    val email: String,
    val password: String,
    val confirmPassword: String,
    val token: String
)

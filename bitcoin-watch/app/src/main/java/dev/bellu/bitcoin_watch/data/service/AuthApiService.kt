package dev.bellu.bitcoin_watch.data.service

import retrofit2.http.GET

interface AuthApiService {
    @GET("login")
    suspend fun login(){}
}
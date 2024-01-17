package dev.bellu.bitcoin_watch.data.network

import dev.bellu.bitcoin_watch.data.service.AuthApiService
import dev.bellu.bitcoin_watch.data.service.BitcoinApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL_BINANCE = "https://api.binance.com/api/v3/"

    private val retrofitBinance: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL_BINANCE)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val bitcoinApiService: BitcoinApiService = retrofitBinance.create(BitcoinApiService::class.java)
}
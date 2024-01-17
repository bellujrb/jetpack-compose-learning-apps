package dev.bellu.bitcoin_watch.data.service

import dev.bellu.bitcoin_watch.data.models.BitcoinBRLModel
import retrofit2.http.GET

interface BitcoinApiService{
    @GET("ticker/24hr?symbol=BTCBRL")
    suspend fun getCurrentBitcoin(): BitcoinBRLModel
}
package dev.bellu.bitcoin_watch.presentation.screens.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dev.bellu.bitcoin_watch.data.models.BitcoinBRLModel
import dev.bellu.bitcoin_watch.data.network.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.withContext

class HomeViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    private val _isModalVisible = mutableStateOf(false)
    val isModalVisible: State<Boolean> get() = _isModalVisible

    private val apiService = RetrofitClient.bitcoinApiService

    suspend fun getBitcoinBRL(): BitcoinBRLModel{
        return withContext(Dispatchers.IO){
            try {
                val bitcoinCurrent = apiService.getCurrentBitcoin()
                val updateBitcoinCurrent = _uiState.value.copy(
                    bitcoinValue = bitcoinCurrent.lastPrice.toDouble(),
                    bitcoinAppreciationValue = bitcoinCurrent.priceChange.toDouble(),
                    bitcoinAppreciationPercentage = bitcoinCurrent.priceChangePercent.toDouble(),
                )
                _uiState.value = updateBitcoinCurrent
                return@withContext bitcoinCurrent
            } catch (e: Exception){
                throw Throwable("Error")
            }
        }
    }

    fun consultBitcoinBRL(value: Double){
        // add logic
        _isModalVisible.value = true
    }

}
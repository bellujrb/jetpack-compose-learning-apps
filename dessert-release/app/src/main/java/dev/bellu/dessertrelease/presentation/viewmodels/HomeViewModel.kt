package dev.bellu.dessertrelease.presentation.viewmodels

import androidx.lifecycle.ViewModel
import dev.bellu.dessertrelease.presentation.screens.HomeUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class HomeViewModel: ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    fun changeView(){
        _uiState.value = _uiState.value.copy(
            isVertical = !_uiState.value.isVertical
        )
    }
}
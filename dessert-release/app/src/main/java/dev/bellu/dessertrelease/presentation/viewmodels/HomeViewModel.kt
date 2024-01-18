package dev.bellu.dessertrelease.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.bellu.dessertrelease.data.store.UserPreferenceStore
import dev.bellu.dessertrelease.presentation.screens.HomeUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeViewModel(private val userPreferenceStore: UserPreferenceStore): ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            userPreferenceStore.getPreference.collect{value ->
                _uiState.value = _uiState.value.copy(
                    isVertical = value.toBoolean()
                )
            }
        }
    }

    fun changeView(){
        _uiState.value = _uiState.value.copy(
            isVertical = !_uiState.value.isVertical
        )

        viewModelScope.launch {
            userPreferenceStore.savePreference(_uiState.value.isVertical.toString())
        }
    }
}
package com.unifae.lucas.mangosapp.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class DashboardScreenState(
  val showValues: Boolean = false,
  val isLoading: Boolean = false,
)

sealed class DashboardScreenEvent {
  object ShowValuesChanged : DashboardScreenEvent()
}

class DashboardScreenViewModel : ViewModel() {
  private val TAG = "DashboardScreenViewModel"
  private val _uiState = MutableStateFlow(DashboardScreenState())
  val uiState: StateFlow<DashboardScreenState> = _uiState.asStateFlow()

  fun onEvent(event: DashboardScreenEvent) {
    when (event) {
      is DashboardScreenEvent.ShowValuesChanged -> {
        _uiState.update { it.copy(showValues = !uiState.value.showValues) }
      }
    }
  }

}

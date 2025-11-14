package com.unifae.lucas.mangosapp.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class ExtratoScreenState(
  val searchValue: String = "",
  val showValues: Boolean = true,
  val isLoading: Boolean = false,
)

sealed class ExtratoScreenEvent {
  data class SearchValueChanged(val value: String) : ExtratoScreenEvent()
  object ShowValuesChanged : ExtratoScreenEvent()
}

class ExtratoScreenViewModel : ViewModel() {
  private val TAG = "ExtratoScreenViewModel"
  private val _uiState = MutableStateFlow(ExtratoScreenState())
  val uiState: StateFlow<ExtratoScreenState> = _uiState.asStateFlow()

  fun onEvent(event: ExtratoScreenEvent) {
    when (event) {
      is ExtratoScreenEvent.SearchValueChanged -> {
        _uiState.update { it.copy(searchValue = event.value) }
      }

      is ExtratoScreenEvent.ShowValuesChanged -> {
        _uiState.update { it.copy(showValues = !uiState.value.showValues) }
      }
    }
  }
}

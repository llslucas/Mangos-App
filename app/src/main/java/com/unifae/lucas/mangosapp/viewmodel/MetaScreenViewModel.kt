package com.unifae.lucas.mangosapp.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class MetaScreenState(
  val isLoading: Boolean = false,
)

sealed class MetaScreenEvent {
}

class MetaScreenViewModel : ViewModel() {
  private val TAG = "MetaScreenViewModel"
  private val _uiState = MutableStateFlow(MetaScreenState())
  val uiState: StateFlow<MetaScreenState> = _uiState.asStateFlow()

  fun onEvent(event: MetaScreenEvent) {

  }
}

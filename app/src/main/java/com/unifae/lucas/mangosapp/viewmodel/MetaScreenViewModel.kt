package com.unifae.lucas.mangosapp.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

/**
 * Estado da UI para a tela de metas, contendo indicador de carregamento.
 *
 * @param isLoading Indica se está carregando (não usado atualmente).
 */
data class MetaScreenState(
  val isLoading: Boolean = false,
)

/**
 * Eventos para a tela de metas (atualmente vazia, sem eventos definidos).
 */
sealed class MetaScreenEvent {
}

/**
 * ViewModel para gerenciar estado da tela de metas (atualmente sem lógica específica).
 */
class MetaScreenViewModel : ViewModel() {
  private val TAG = "MetaScreenViewModel"
  private val _uiState = MutableStateFlow(MetaScreenState())
  val uiState: StateFlow<MetaScreenState> = _uiState.asStateFlow()

  /**
   * Processa eventos da tela (atualmente sem implementação, pois não há eventos definidos).
   *
   * @param event Evento a ser processado.
   */
  fun onEvent(event: MetaScreenEvent) {
    // Função vazia, pois não há eventos definidos
  }
}

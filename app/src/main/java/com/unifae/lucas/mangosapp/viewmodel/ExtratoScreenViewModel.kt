package com.unifae.lucas.mangosapp.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

/**
 * Estado da UI para a tela de extrato, contendo configurações de busca e exibição.
 *
 * @param searchValue Texto de busca para filtrar transações.
 * @param showValues Se true, mostra valores monetários; se false, oculta.
 * @param isLoading Indica se está carregando (não usado atualmente).
 */
data class ExtratoScreenState(
  val searchValue: String = "",
  val showValues: Boolean = true,
  val isLoading: Boolean = false,
)

/**
 * Eventos para a tela de extrato, usados para alterar busca ou visibilidade de valores.
 */
sealed class ExtratoScreenEvent {
  data class SearchValueChanged(val value: String) : ExtratoScreenEvent()
  object ShowValuesChanged : ExtratoScreenEvent()
}

/**
 * ViewModel para gerenciar estado da tela de extrato, incluindo busca e alternância de visibilidade.
 */
class ExtratoScreenViewModel : ViewModel() {
  private val TAG = "ExtratoScreenViewModel"
  private val _uiState = MutableStateFlow(ExtratoScreenState())
  val uiState: StateFlow<ExtratoScreenState> = _uiState.asStateFlow()

  /**
   * Processa eventos da tela, atualizando busca ou visibilidade de valores.
   *
   * @param event Evento a ser processado.
   */
  fun onEvent(event: ExtratoScreenEvent) {
    when (event) {
      is ExtratoScreenEvent.SearchValueChanged -> {
        // Atualiza o valor de busca
        _uiState.update { it.copy(searchValue = event.value) }
      }

      is ExtratoScreenEvent.ShowValuesChanged -> {
        // Alterna o valor de showValues
        _uiState.update { it.copy(showValues = !uiState.value.showValues) }
      }
    }
  }
}

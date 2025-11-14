package com.unifae.lucas.mangosapp.viewmodel

import androidx.lifecycle.ViewModel
import com.unifae.lucas.mangosapp.model.aggregate.Transactions
import com.unifae.lucas.mangosapp.model.core.TransactionWithDetails
import com.unifae.lucas.mangosapp.utils.mockTransactionsWithDetails
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

/**
 * Estado da UI para a tela de dashboard, contendo configurações de exibição e dados de transações.
 *
 * @param showValues Se true, mostra valores monetários; se false, oculta.
 * @param isLoading Indica se está carregando (não usado atualmente).
 * @param transactions Objeto agregador com lista de transações e métodos de cálculo.
 */
data class DashboardScreenState(
  val showValues: Boolean = true,
  val isLoading: Boolean = false,
  val transactions: Transactions? = null
)

/**
 * Eventos para a tela de dashboard, usados para alterar configurações de UI.
 */
sealed class DashboardScreenEvent {
  object ShowValuesChanged : DashboardScreenEvent()
}

/**
 * ViewModel para gerenciar estado da tela de dashboard, incluindo alternância de visibilidade de valores.
 */
class DashboardScreenViewModel : ViewModel() {
  private val TAG = "DashboardScreenViewModel"
  private val _uiState = MutableStateFlow(DashboardScreenState(
    transactions = Transactions(mockTransactionsWithDetails)
  ))
  val uiState: StateFlow<DashboardScreenState> = _uiState.asStateFlow()

  /**
   * Processa eventos da tela, alternando a visibilidade de valores.
   *
   * @param event Evento a ser processado.
   */
  fun onEvent(event: DashboardScreenEvent) {
    when (event) {
      is DashboardScreenEvent.ShowValuesChanged -> {
        // Alterna o valor de showValues
        _uiState.update { it.copy(showValues = !uiState.value.showValues) }
      }
    }
  }

}

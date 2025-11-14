package com.unifae.lucas.mangosapp.viewmodel

import androidx.lifecycle.ViewModel
import com.unifae.lucas.mangosapp.model.aggregate.Transactions
import com.unifae.lucas.mangosapp.model.core.TransactionWithDetails
import com.unifae.lucas.mangosapp.utils.mockTransactionsWithDetails
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class DashboardScreenState(
  val showValues: Boolean = true,
  val isLoading: Boolean = false,
  val transactions: Transactions? = null
)

sealed class DashboardScreenEvent {
  object ShowValuesChanged : DashboardScreenEvent()
}

class DashboardScreenViewModel : ViewModel() {
  private val TAG = "DashboardScreenViewModel"
  private val _uiState = MutableStateFlow(DashboardScreenState(
    transactions = Transactions(mockTransactionsWithDetails)
  ))
  val uiState: StateFlow<DashboardScreenState> = _uiState.asStateFlow()

  fun onEvent(event: DashboardScreenEvent) {
    when (event) {
      is DashboardScreenEvent.ShowValuesChanged -> {
        _uiState.update { it.copy(showValues = !uiState.value.showValues) }
      }
    }
  }

}

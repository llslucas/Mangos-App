package com.unifae.lucas.mangosapp.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import android.util.Log

data class CreateTransactionState(
  val type: String = "",
  val date: String = "",
  val value: String = "",
  val bank: String = "",
  val category: String = "",
  val isLoading: Boolean = false,
)

sealed class CreateTransactionEventForm {
  data class TypeChanged(val value: String) : CreateTransactionEventForm()
  data class DateChanged(val value: String) : CreateTransactionEventForm()
  data class ValueChanged(val value: String) : CreateTransactionEventForm()
  data class BankChanged(val value: String) : CreateTransactionEventForm()
  data class CategoryChanged(val value: String) : CreateTransactionEventForm()
  object SaveButtonClicked : CreateTransactionEventForm()
}

class CreateTransactionViewModel : ViewModel() {
  private val TAG = "CreateTransactionViewModel"
  private val _uiState = MutableStateFlow(CreateTransactionState())
  val uiState: StateFlow<CreateTransactionState> = _uiState.asStateFlow()

  fun saveTransaction() {
    Log.d(TAG, "Função 'saveTransaction' Iniciada")
    Log.d(TAG, "Estado atual: ${uiState.value}")

    //TODO: Implement save function
  }

  fun onEvent(event: CreateTransactionEventForm) {
    when (event) {
      is CreateTransactionEventForm.TypeChanged -> {
        _uiState.update { it.copy(type = event.value) }
      }

      is CreateTransactionEventForm.DateChanged -> {
        _uiState.update { it.copy(date = event.value) }
      }

      is CreateTransactionEventForm.ValueChanged -> {
        _uiState.update { it.copy(value = event.value) }
      }

      is CreateTransactionEventForm.BankChanged -> {
        _uiState.update { it.copy(bank = event.value) }
      }

      is CreateTransactionEventForm.CategoryChanged -> {
        _uiState.update { it.copy(category = event.value) }
      }

      is CreateTransactionEventForm.SaveButtonClicked -> {
        saveTransaction()
      }

    }
  }

}

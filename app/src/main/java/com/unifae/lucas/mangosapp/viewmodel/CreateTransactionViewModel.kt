package com.unifae.lucas.mangosapp.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import android.util.Log

/**
 * Estado da UI para criação de transação, contendo campos do formulário e indicador de carregamento.
 *
 * @param type Tipo da transação (ex.: "Receita" ou "Despesa").
 * @param date Data da transação.
 * @param value Valor da transação como string.
 * @param bank Banco associado.
 * @param category Categoria da transação.
 * @param isLoading Indica se está carregando (não usado atualmente).
 */
data class CreateTransactionState(
  val type: String = "",
  val date: String = "",
  val value: String = "",
  val bank: String = "",
  val category: String = "",
  val isLoading: Boolean = false,
)

/**
 * Eventos do formulário para criação de transação, usados para atualizar estado ou salvar.
 */
sealed class CreateTransactionEventForm {
  data class TypeChanged(val value: String) : CreateTransactionEventForm()
  data class DateChanged(val value: String) : CreateTransactionEventForm()
  data class ValueChanged(val value: String) : CreateTransactionEventForm()
  data class BankChanged(val value: String) : CreateTransactionEventForm()
  data class CategoryChanged(val value: String) : CreateTransactionEventForm()
  object SaveButtonClicked : CreateTransactionEventForm()
}

/**
 * ViewModel para gerenciar estado e lógica de criação de transação.
 */
class CreateTransactionViewModel : ViewModel() {
  private val TAG = "CreateTransactionViewModel"
  private val _uiState = MutableStateFlow(CreateTransactionState())
  val uiState: StateFlow<CreateTransactionState> = _uiState.asStateFlow()

  /**
   * Salva uma nova transação (implementação pendente).
   */
  fun saveTransaction() {
    Log.d(TAG, "Função 'saveTransaction' Iniciada")
    Log.d(TAG, "Estado atual: ${uiState.value}")

    //TODO: Implement save function
  }

  /**
   * Processa eventos do formulário, atualizando estado ou salvando transação.
   *
   * @param event Evento a ser processado.
   */
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
        // Chama função de salvar (atualmente com TODO)
        saveTransaction()
      }

    }
  }

}

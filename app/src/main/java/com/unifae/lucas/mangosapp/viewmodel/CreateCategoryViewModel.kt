package com.unifae.lucas.mangosapp.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import android.util.Log

/**
 * Estado da UI para criação de categoria, contendo campos do formulário e indicador de carregamento.
 *
 * @param categoryName Nome da categoria.
 * @param goalValue Valor da meta como string.
 * @param isLoading Indica se está carregando (não usado atualmente).
 */
data class CreateCategoryState(
  val categoryName: String = "",
  val goalValue: String = "0",
  val isLoading: Boolean = false,
)

/**
 * Eventos do formulário para criação de categoria, usados para atualizar estado ou salvar.
 */
sealed class CreateCategoryEventForm {
  data class CategoryNameChanged(val value: String): CreateCategoryEventForm()
  data class GoalValueChanged(val value: String): CreateCategoryEventForm()
  object SaveButtonClicked : CreateCategoryEventForm()
}

/**
 * ViewModel para gerenciar estado e lógica de criação de categoria.
 */
class CreateCategoryViewModel : ViewModel() {
  private val TAG = "CreateCategoryViewModel"
  private val _uiState = MutableStateFlow(CreateCategoryState())
  val uiState: StateFlow<CreateCategoryState> = _uiState.asStateFlow()

  /**
   * Salva uma nova categoria (implementação pendente).
   */
  fun saveCategory() {
    Log.d(TAG, "Função 'saveCategory' Iniciada")
    Log.d(TAG, "Estado atual: ${uiState.value}")

    //TODO: Implement save function
  }

  /**
   * Processa eventos do formulário, atualizando estado ou salvando categoria.
   *
   * @param event Evento a ser processado.
   */
  fun onEvent(event: CreateCategoryEventForm) {
    when(event) {
      is CreateCategoryEventForm.CategoryNameChanged -> {
        _uiState.update { it.copy(categoryName = event.value) }
      }

      is CreateCategoryEventForm.GoalValueChanged -> {
        _uiState.update { it.copy(goalValue = event.value) }
      }

      is CreateCategoryEventForm.SaveButtonClicked -> {
        // Chama função de salvar (atualmente com TODO)
        saveCategory()
      }
    }
  }

}

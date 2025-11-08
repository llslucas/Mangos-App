package com.unifae.lucas.mangosapp.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import android.util.Log

data class CreateCategoryState(
  val categoryName: String = "",
  val goalValue: String = "0",
  val isLoading: Boolean = false,
)

sealed class CreateCategoryEventForm {
  data class CategoryNameChanged(val value: String): CreateCategoryEventForm()
  data class GoalValueChanged(val value: String): CreateCategoryEventForm()
  object SaveButtonClicked : CreateCategoryEventForm()
}

class CreateCategoryViewModel : ViewModel() {
  private val TAG = "CreateCategoryViewModel"
  private val _uiState = MutableStateFlow(CreateCategoryState())
  val uiState: StateFlow<CreateCategoryState> = _uiState.asStateFlow()

  fun saveCategory() {
    Log.d(TAG, "Função 'saveCategory' Iniciada")
    Log.d(TAG, "Estado atual: ${uiState.value}")

    //TODO: Implement save function
  }

  fun onEvent(event: CreateCategoryEventForm) {
    when(event) {
      is CreateCategoryEventForm.CategoryNameChanged -> {
        _uiState.update { it.copy(categoryName = event.value) }
      }

      is CreateCategoryEventForm.GoalValueChanged -> {
        _uiState.update { it.copy(goalValue = event.value) }
      }

      is CreateCategoryEventForm.SaveButtonClicked -> {
        saveCategory()
      }
    }
  }

}

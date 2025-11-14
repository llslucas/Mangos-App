package com.unifae.lucas.mangosapp.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import android.util.Log
import androidx.lifecycle.viewModelScope
import com.unifae.lucas.mangosapp.model.core.Bank
import com.unifae.lucas.mangosapp.persistence.repository.BankRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

data class CreateBankState(
  val bankName: String = "",
  val account: String = "",
  val agency: String = "",
  val owner: String = "",
  val isLoading: Boolean = false,
)

sealed class CreateBankEventForm {
  data class BankNameChanged(val value: String): CreateBankEventForm()
  data class AccountChanged(val value: String): CreateBankEventForm()
  data class AgencyChanged(val value: String): CreateBankEventForm()
  data class OwnerChanged(val value: String): CreateBankEventForm()
  object SaveButtonClicked : CreateBankEventForm()
}

@HiltViewModel
class CreateBankViewModel @Inject constructor(
  private val repository: BankRepository
) : ViewModel() {
  private val TAG = "CreateBankViewModel"
  private val _uiState = MutableStateFlow(CreateBankState())
  val uiState: StateFlow<CreateBankState> = _uiState.asStateFlow()

  suspend fun saveBank() {
    Log.d(TAG, "Função 'saveBank' Iniciada")
    Log.d(TAG, "Estado atual: ${uiState.value}")

    val newBank = Bank(
      name = uiState.value.bankName,
      account = uiState.value.account,
      agencia = uiState.value.agency,
      titular = uiState.value.owner
    )

    repository.insert(newBank);
  }

  fun onEvent(event: CreateBankEventForm) {
    when(event) {
      is CreateBankEventForm.BankNameChanged -> {
        _uiState.update { it.copy(bankName = event.value) }
      }

      is CreateBankEventForm.AccountChanged -> {
        _uiState.update { it.copy(account = event.value) }
      }

      is CreateBankEventForm.AgencyChanged -> {
        _uiState.update { it.copy(agency = event.value) }
      }

      is CreateBankEventForm.OwnerChanged -> {
        _uiState.update { it.copy(owner = event.value) }
      }

      is CreateBankEventForm.SaveButtonClicked -> {
        viewModelScope.launch {
          saveBank()
        }
      }
    }
  }

}

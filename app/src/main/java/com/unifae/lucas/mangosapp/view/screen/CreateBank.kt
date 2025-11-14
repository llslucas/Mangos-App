package com.unifae.lucas.mangosapp.view.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.unifae.lucas.mangosapp.view.component.CustomButton
import com.unifae.lucas.mangosapp.view.component.Footer
import com.unifae.lucas.mangosapp.view.component.FormInput
import com.unifae.lucas.mangosapp.view.component.ScreenHeader
import com.unifae.lucas.mangosapp.view.component.SubHeader
import com.unifae.lucas.mangosapp.view.theme.MangosAppTheme
import com.unifae.lucas.mangosapp.viewmodel.CreateBankEventForm
import com.unifae.lucas.mangosapp.viewmodel.CreateBankViewModel

@Composable
fun CreateBankScreen(
  modifier: Modifier = Modifier,
  viewModel: CreateBankViewModel = hiltViewModel(),
  onChangeToExtrato: () -> Unit = {},
  onChangeToHome: () -> Unit = {},
  onChangeToMetas: () -> Unit = {},
) {
  val uiState by viewModel.uiState.collectAsState()

  Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
    Column(
      modifier = Modifier
        .padding(innerPadding)
        .padding(top = MangosAppTheme.sizing.md)
        .fillMaxSize(),
      verticalArrangement = Arrangement.SpaceBetween,
    ) {
      Column {
        ScreenHeader(
          modifier = Modifier.padding(start = MangosAppTheme.sizing.md),
          title =  "Novo Banco",
          onBack = {
            onChangeToHome()
          }
        )
        SubHeader(
          modifier = Modifier.padding(MangosAppTheme.sizing.md),
          title = "Cadastre seus bancos para um melhor controle dos seus saldos."
        )
      }

      Column(
        modifier = Modifier.fillMaxHeight(.8f).padding(horizontal = MangosAppTheme.sizing.md),
        verticalArrangement = Arrangement.spacedBy(MangosAppTheme.sizing.md)
      ){
        FormInput(
          title = "Banco",
          placeholder = "Exemplo: Santander",
          value = uiState.bankName,
          onChange = {newValue ->
            viewModel.onEvent(CreateBankEventForm.BankNameChanged(newValue))
          }
        )
        FormInput(
          title = "Conta",
          placeholder = "Exemplo: 12345-6 ",
          value = uiState.account,
          onChange = {newValue ->
            viewModel.onEvent(CreateBankEventForm.AccountChanged(newValue))
          }
        )
        FormInput(
          title = "Agencia",
          placeholder = "Exemplo: 0000",
          value = uiState.agency,
          onChange = {newValue ->
            viewModel.onEvent(CreateBankEventForm.AgencyChanged(newValue))
          }
        )
        FormInput(
          title = "Titular",
          placeholder = "Exemplo: Fulano",
          value = uiState.owner,
          onChange = {newValue ->
            viewModel.onEvent(CreateBankEventForm.OwnerChanged(newValue))
          }
        )
      }
      CustomButton(
        modifier = Modifier
          .fillMaxWidth()
          .padding(MangosAppTheme.sizing.md)
        ,text = "Salvar",
        onClick = {
          viewModel.onEvent(CreateBankEventForm.SaveButtonClicked)
        },
      )
      Footer(
        selected = 0,
        onClick = { button ->
          when(button){
            1 -> onChangeToExtrato()
            2 -> onChangeToHome()
            3 -> onChangeToMetas()
          }
        }
      )
    }
  }
}

@PreviewLightDark
@Composable
private fun CreateBankScreenPreview() {
  MangosAppTheme {
    CreateBankScreen()
  }
}
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.lifecycle.viewmodel.compose.viewModel
import com.unifae.lucas.mangosapp.view.component.CustomButton
import com.unifae.lucas.mangosapp.view.component.Footer
import com.unifae.lucas.mangosapp.view.component.FormInput
import com.unifae.lucas.mangosapp.view.component.ScreenHeader
import com.unifae.lucas.mangosapp.view.component.SubHeader
import com.unifae.lucas.mangosapp.view.theme.MangosAppTheme
import com.unifae.lucas.mangosapp.viewmodel.CreateTransactionEventForm
import com.unifae.lucas.mangosapp.viewmodel.CreateTransactionViewModel

/**
 * Tela para criação de uma nova transação, com formulário de entrada e navegação.
 *
 * @param modifier Modifier opcional aplicado ao Scaffold.
 * @param viewModel ViewModel para gerenciar estado e eventos.
 * @param onChangeToExtrato Função para navegar à tela de extrato.
 * @param onChangeToHome Função para navegar à tela inicial.
 * @param onChangeToMetas Função para navegar à tela de metas.
 *
 * Uso: tela de formulário para registrar transações financeiras, integrada com ViewModel para estado reativo.
 */
@Composable
fun CreateTransactionScreen(
  modifier: Modifier = Modifier,
  viewModel: CreateTransactionViewModel = viewModel(),
  onChangeToExtrato: () -> Unit = {},
  onChangeToHome: () -> Unit = {},
  onChangeToMetas: () -> Unit = {},
) {
  // Coleta o estado da UI do ViewModel
  val uiState by viewModel.uiState.collectAsState()

  // Scaffold para estrutura básica da tela
  Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
    // Coluna principal dividindo cabeçalho, formulário, botão e footer
    Column(
      modifier = Modifier
        .padding(innerPadding)
        .padding(top = MangosAppTheme.sizing.md)
        .fillMaxSize(),
      verticalArrangement = Arrangement.SpaceBetween,
    ) {
      // Seção superior: cabeçalho e subtítulo
      Column {
        ScreenHeader(
          modifier = Modifier.padding(start = MangosAppTheme.sizing.md),
          title = "Nova Transação",
          onBack = {onChangeToHome()}
        )
        SubHeader(
          modifier = Modifier.padding(MangosAppTheme.sizing.md),
          title = "Registre suas receitas e despesas para acompanhar melhor suas finanças."
        )
      }
      // Seção central: formulário com campos de entrada
      Column(
        modifier = Modifier
          .fillMaxHeight(.8f)
          .padding(horizontal = MangosAppTheme.sizing.md),
        verticalArrangement = Arrangement.spacedBy(MangosAppTheme.sizing.md)
      ) {
        FormInput(
          title = "Tipo de transação",
          placeholder = "Despesa ou Receita",
          value = uiState.type,
          onChange = { newValue ->
            viewModel.onEvent(CreateTransactionEventForm.TypeChanged(newValue))
          }
        )
        FormInput(
          title = "Data",
          placeholder = "Exemplo: 07/09/2025",
          value = uiState.date,
          onChange = { newValue ->
            viewModel.onEvent(CreateTransactionEventForm.DateChanged(newValue))
          }
        )
        FormInput(
          title = "Valor",
          placeholder = "Exemplo: R$33,33",
          value = uiState.value,
          onChange = { newValue ->
            viewModel.onEvent(CreateTransactionEventForm.ValueChanged(newValue))
          }
        )
        FormInput(
          title = "Banco",
          placeholder = "Exemplo: Itaú",
          value = uiState.bank,
          onChange = { newValue ->
            viewModel.onEvent(CreateTransactionEventForm.BankChanged(newValue))
          }
        )
        FormInput(
          title = "Categoria",
          placeholder = "Exemplo: Despesas Fixas",
          value = uiState.category,
          onChange = { newValue ->
            viewModel.onEvent(CreateTransactionEventForm.CategoryChanged(newValue))
          }
        )
      }
      // Botão de salvar
      CustomButton(
        modifier = Modifier
          .fillMaxWidth()
          .padding(MangosAppTheme.sizing.md),
        text = "Salvar",
        onClick = {
          viewModel.onEvent(CreateTransactionEventForm.SaveButtonClicked)
        },
      )
      // Footer de navegação
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

/**
 * Preview da CreateTransactionScreen.
 * Mostra a tela dentro do tema da aplicação.
 */
@PreviewLightDark
@Composable
private fun CreateTransactionScreenPreview() {
  MangosAppTheme {
    CreateTransactionScreen()
  }
}
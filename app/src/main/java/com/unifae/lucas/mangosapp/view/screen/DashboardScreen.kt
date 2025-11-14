package com.unifae.lucas.mangosapp.view.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.unifae.lucas.mangosapp.view.component.BankBalance
import com.unifae.lucas.mangosapp.view.component.BankType
import com.unifae.lucas.mangosapp.view.component.BodyCard
import com.unifae.lucas.mangosapp.view.component.CurrencySize
import com.unifae.lucas.mangosapp.view.component.CurrencyText
import com.unifae.lucas.mangosapp.view.component.ExpenseCategory
import com.unifae.lucas.mangosapp.view.component.ExpenseCategoryType
import com.unifae.lucas.mangosapp.view.component.Footer
import com.unifae.lucas.mangosapp.view.component.HeaderCard
import com.unifae.lucas.mangosapp.view.component.NewBank
import com.unifae.lucas.mangosapp.view.component.Result
import com.unifae.lucas.mangosapp.view.component.ShowValuesIcon
import com.unifae.lucas.mangosapp.view.theme.MangosAppTheme
import com.unifae.lucas.mangosapp.view.theme.Typography
import com.unifae.lucas.mangosapp.viewmodel.DashboardScreenEvent
import com.unifae.lucas.mangosapp.viewmodel.DashboardScreenViewModel

/**
 * Tela principal do dashboard, exibindo saldo, receitas/despesas, despesas por categoria e saldos em contas.
 *
 * @param viewModel ViewModel para gerenciar estado e eventos.
 * @param onChangeToExtrato Função para navegar à tela de extrato.
 * @param onChangeToMetas Função para navegar à tela de metas.
 * @param onChangeToNewBank Função para navegar à tela de criação de banco.
 * @param onChangeToNewTransaction Função para navegar à tela de criação de transação.
 *
 * Uso: tela inicial do app, mostrando resumo financeiro com navegação integrada.
 */
@Composable
fun DashboardScreen(
  viewModel: DashboardScreenViewModel = viewModel(),
  onChangeToExtrato: () -> Unit = {},
  onChangeToHome: () -> Unit = {},
  onChangeToMetas: () -> Unit = {},
  onChangeToNewBank: () -> Unit = {},
  onChangeToNewTransaction: () -> Unit = {},
) {
  // Coleta o estado da UI do ViewModel
  val uiState by viewModel.uiState.collectAsState()

  // Scaffold para estrutura básica da tela
  Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
    // Coluna principal dividindo header, body cards e footer
    Column(
      modifier = Modifier
        .padding(innerPadding)
        .fillMaxSize(),
      verticalArrangement = Arrangement.SpaceBetween
    ) {
      // HeaderCard com saldo mensal e receitas/despesas
      HeaderCard(
        modifier = Modifier.height(210.dp)
      ) {
        // Coluna centralizada com mês, saldo e resultados
        Column(
          modifier = Modifier.fillMaxSize(),
          horizontalAlignment = Alignment.CenterHorizontally,
          verticalArrangement = Arrangement.SpaceEvenly
        ) {
          // Row com mês e ícone de dropdown
          Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
          ) {
            Text(
              text = "Setembro",
              style = Typography.headlineLarge
            )
            Icon(
              imageVector = Icons.Default.ArrowDropDown,
              contentDescription = null
            )
          }

          // Coluna com texto "Seu Saldo" e valor com ícone de toggle
          Column(
            horizontalAlignment = Alignment.CenterHorizontally
          ) {
            Text(
              text = "Seu Saldo",
              style = Typography.headlineSmall
            )
            Row(
              verticalAlignment = Alignment.CenterVertically
            ) {
              CurrencyText(
                value = uiState.transactions?.getBalance() ?: 0f,
                showValues = uiState.showValues,
                size = CurrencySize.LARGE
              )
              ShowValuesIcon(
                showValues = uiState.showValues,
                onClick = {
                  viewModel.onEvent(DashboardScreenEvent.ShowValuesChanged)
                }
              )
            }
          }

          // Row com receitas e despesas
          Row(
            horizontalArrangement = Arrangement.spacedBy(MangosAppTheme.sizing.xl)
          ) {
            Result(
              value = uiState.transactions?.getIncome() ?: 0f,
              showValues = uiState.showValues,
            )

            Result(
              value = uiState.transactions?.getExpenses() ?: 0f,
              showValues = uiState.showValues,
            )
          }
        }
      }
      // BodyCard com despesas por categoria
      BodyCard(
        title = "Despesas por Categoria",
        modifier = Modifier.height(250.dp)
      ) {
        // Row com duas colunas de categorias
        Row(
          modifier = Modifier.fillMaxSize(),
          verticalAlignment = Alignment.CenterVertically,
          horizontalArrangement = Arrangement.SpaceEvenly
        ) {
          // Primeira coluna de categorias
          Column(
            verticalArrangement = Arrangement.spacedBy(MangosAppTheme.sizing.md)
          ) {
            ExpenseCategory(
              type = ExpenseCategoryType.BANK,
              name = "Financiamento",
              value = 150.00f,
              showValues = uiState.showValues
            )
            ExpenseCategory(
              type = ExpenseCategoryType.FOOD,
              name = "Alimentação",
              value = 150.00f,
              showValues = uiState.showValues
            )
            ExpenseCategory(
              type = ExpenseCategoryType.HEALTH,
              name = "Saúde",
              value = 150.00f,
              showValues = uiState.showValues
            )
          }
          // Segunda coluna de categorias
          Column(
            verticalArrangement = Arrangement.spacedBy(MangosAppTheme.sizing.md)
          ) {
            ExpenseCategory(
              type = ExpenseCategoryType.BANK,
              name = "Financiamento",
              value = 150.00f,
              showValues = uiState.showValues
            )
            ExpenseCategory(
              type = ExpenseCategoryType.FOOD,
              name = "Alimentação",
              value = 150.00f,
              showValues = uiState.showValues
            )
            ExpenseCategory(
              type = ExpenseCategoryType.HEALTH,
              name = "Saúde",
              value = 150.00f,
              showValues = uiState.showValues
            )
          }
        }
      }
      // BodyCard com saldo em contas
      BodyCard(
        title = "Saldo em Contas",
        modifier = Modifier.height(250.dp)
      ) {
        // Coluna com saldos de bancos e opção de novo banco
        Column(
          modifier = Modifier
            .padding(MangosAppTheme.sizing.lg)
            .fillMaxSize(),
          horizontalAlignment = Alignment.CenterHorizontally,
          verticalArrangement = Arrangement.SpaceBetween
        ) {
          BankBalance(
            name = "Nubank",
            bankType = BankType.NUBANK,
            value = 333.33f,
            showValues = uiState.showValues,
            onClick = {onChangeToNewTransaction()}
          )
          BankBalance(
            name = "Itaú",
            bankType = BankType.ITAU,
            value = 333.33f,
            showValues = uiState.showValues,
            onClick = {onChangeToNewTransaction()}
          )
          NewBank(
            onClick = {onChangeToNewBank()}
          )
        }
      }
      // Footer de navegação
      Footer(
        selected = 2,
        onClick = { button ->
          when(button){
            1 -> onChangeToExtrato()
            3 -> onChangeToMetas()
          }
        }
      )
    }
  }
}

/**
 * Preview da DashboardScreen.
 * Mostra a tela dentro do tema da aplicação.
 */
@PreviewLightDark
@Composable
private fun DashboardScreenPreview() {
  MangosAppTheme {
    DashboardScreen()
  }
}
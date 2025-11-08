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
import androidx.compose.runtime.LaunchedEffect
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
import com.unifae.lucas.mangosapp.view.component.Result
import com.unifae.lucas.mangosapp.view.component.ShowValuesIcon
import com.unifae.lucas.mangosapp.view.theme.MangosAppTheme
import com.unifae.lucas.mangosapp.view.theme.Typography
import com.unifae.lucas.mangosapp.viewmodel.DashboardScreenEvent
import com.unifae.lucas.mangosapp.viewmodel.DashboardScreenViewModel

@Composable
fun DashboardScreen(
  viewModel: DashboardScreenViewModel = viewModel(),
  onChangeToExtrato: () -> Unit = {},
  onChangeToMetas: () -> Unit = {}
) {
  val uiState by viewModel.uiState.collectAsState()

  Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
    Column(
      modifier = Modifier
        .padding(innerPadding)
        .fillMaxSize(),
      verticalArrangement = Arrangement.SpaceBetween
    ) {
      HeaderCard(
      ) {
        Column(
          modifier = Modifier.fillMaxSize(),
          horizontalAlignment = Alignment.CenterHorizontally,
          verticalArrangement = Arrangement.SpaceEvenly
        ) {
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
                value = 3333.33f,
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

          Row(
            horizontalArrangement = Arrangement.spacedBy(MangosAppTheme.sizing.xl)
          ) {
            Result(
              value = 1111.11f,
              showValues = uiState.showValues,
            )

            Result(
              value = -1111.11f,
              showValues = uiState.showValues,
            )
          }
        }
      }
      BodyCard(
        title = "Despesas por Categoria",
        modifier = Modifier.height(250.dp)
      ) {
        Row(
          modifier = Modifier.fillMaxSize(),
          verticalAlignment = Alignment.CenterVertically,
          horizontalArrangement = Arrangement.SpaceEvenly
        ) {
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
      BodyCard(
        title = "Saldo em Contas",
        modifier = Modifier.height(250.dp)
      ) {
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
            showValues = uiState.showValues
          )
          BankBalance(
            name = "Itaú",
            bankType = BankType.ITAU,
            value = 333.33f,
            showValues = uiState.showValues
          )
          BankBalance(
            name = "Santander",
            bankType = BankType.SANTANDER,
            value = 333.33f,
            showValues = uiState.showValues
          )
        }
      }
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


@PreviewLightDark
@Composable
private fun DashboardScreenPreview() {
  MangosAppTheme {
    DashboardScreen()
  }
}
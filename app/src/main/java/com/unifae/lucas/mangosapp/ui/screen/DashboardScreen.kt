package com.unifae.lucas.mangosapp.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.unifae.lucas.mangosapp.ui.component.BankBalance
import com.unifae.lucas.mangosapp.ui.component.BankType
import com.unifae.lucas.mangosapp.ui.component.BodyCard
import com.unifae.lucas.mangosapp.ui.component.CurrencySize
import com.unifae.lucas.mangosapp.ui.component.CurrencyText
import com.unifae.lucas.mangosapp.ui.component.ExpenseCategory
import com.unifae.lucas.mangosapp.ui.component.ExpenseCategoryType
import com.unifae.lucas.mangosapp.ui.component.Footer
import com.unifae.lucas.mangosapp.ui.component.HeaderCard
import com.unifae.lucas.mangosapp.ui.component.Result
import com.unifae.lucas.mangosapp.ui.component.ShowValuesIcon
import com.unifae.lucas.mangosapp.ui.theme.MangosAppTheme
import com.unifae.lucas.mangosapp.ui.theme.Typography

@Composable
fun DashboardScreen() {
  var showValues by remember { mutableStateOf(true) }

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
                showValues = showValues,
                size = CurrencySize.LARGE
              )
              ShowValuesIcon(
                showValues = showValues,
                onClick = {
                  showValues = !showValues
                }
              )
            }
          }

          Row(
            horizontalArrangement = Arrangement.spacedBy(MangosAppTheme.sizing.xl)
          ) {
            Result(
              value = 1111.11f,
              showValues = showValues,
            )

            Result(
              value = -1111.11f,
              showValues = showValues,
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
              showValues = showValues
            )
            ExpenseCategory(
              type = ExpenseCategoryType.FOOD,
              name = "Alimentação",
              value = 150.00f,
              showValues = showValues
            )
            ExpenseCategory(
              type = ExpenseCategoryType.HEALTH,
              name = "Saúde",
              value = 150.00f,
              showValues = showValues
            )
          }
          Column(
            verticalArrangement = Arrangement.spacedBy(MangosAppTheme.sizing.md)
          ) {
            ExpenseCategory(
              type = ExpenseCategoryType.BANK,
              name = "Financiamento",
              value = 150.00f,
              showValues = showValues
            )
            ExpenseCategory(
              type = ExpenseCategoryType.FOOD,
              name = "Alimentação",
              value = 150.00f,
              showValues = showValues
            )
            ExpenseCategory(
              type = ExpenseCategoryType.HEALTH,
              name = "Saúde",
              value = 150.00f,
              showValues = showValues
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
            showValues = showValues
          )
          BankBalance(
            name = "Itaú",
            bankType = BankType.ITAU,
            value = 333.33f,
            showValues = showValues
          )
          BankBalance(
            name = "Santander",
            bankType = BankType.SANTANDER,
            value = 333.33f,
            showValues = showValues
          )
        }
      }
      Footer(
        selected = 2,
        onClick = {}
      )
    }
  }
}


@Preview
@Composable
private fun DashboardScreenPreview() {
  MangosAppTheme {
    DashboardScreen()
  }
}
package com.unifae.lucas.mangosapp.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.unifae.lucas.mangosapp.ui.component.CustomButton
import com.unifae.lucas.mangosapp.ui.component.Footer
import com.unifae.lucas.mangosapp.ui.component.FormInput
import com.unifae.lucas.mangosapp.ui.component.ScreenHeader
import com.unifae.lucas.mangosapp.ui.component.SubHeader
import com.unifae.lucas.mangosapp.ui.theme.MangosAppTheme

@Composable
fun CreateTransactionScreen(modifier: Modifier = Modifier) {
  var showValues by remember { mutableStateOf(true) }
  val (type, setType) = remember {mutableStateOf("")}
  val (data, setData) = remember {mutableStateOf("")}
  val (valor, setValor) = remember {mutableStateOf("")}
  val (bank, setBank) = remember {mutableStateOf("")}
  val (category, setCategory) = remember {mutableStateOf("")}

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
          title =  "Nova Transação",
          onBack = {}
        )
        SubHeader(
          modifier = Modifier.padding(MangosAppTheme.sizing.md),
          title = "Registre suas receitas e despesas para acompanhar melhor suas finanças."
        )
      }
      Column(
        modifier = Modifier.fillMaxHeight(.8f).padding(horizontal = MangosAppTheme.sizing.md),
        verticalArrangement = Arrangement.spacedBy(MangosAppTheme.sizing.md)
      ){
        FormInput(
          title = "Tipo de transação",
          placeholder = "Despesa ou Receita",
          value = "",
          onChange = setType
        )
        FormInput(
          title = "Data",
          placeholder = "Exemplo: 07/09/2025",
          value = "",
          onChange = setData
        )
        FormInput(
          title = "Valor",
          placeholder = "Exemplo: R$33,33",
          value = "",
          onChange = setValor
        )
        FormInput(
          title = "Banco",
          placeholder = "Exemplo: Itaú",
          value = "",
          onChange = setBank
        )
        FormInput(
          title = "Categoria",
          placeholder = "Exemplo: Despesas Fixas",
          value = "",
          onChange = setCategory
        )
      }
      CustomButton(
        modifier = Modifier
          .fillMaxWidth()
          .padding(MangosAppTheme.sizing.md)
        ,text = "Salvar",
        onClick = {},
      )
      Footer(
        selected = 1,
        onClick = {}
      )
    }
  }
}

@PreviewLightDark
@Composable
private fun CreateTransactionScreenPreview() {
  MangosAppTheme {
    CreateTransactionScreen()
  }
}
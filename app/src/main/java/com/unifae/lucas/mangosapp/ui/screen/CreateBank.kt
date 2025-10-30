package com.unifae.lucas.mangosapp.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.unifae.lucas.mangosapp.ui.component.CustomButton
import com.unifae.lucas.mangosapp.ui.component.Footer
import com.unifae.lucas.mangosapp.ui.component.FormInput
import com.unifae.lucas.mangosapp.ui.component.ScreenHeader
import com.unifae.lucas.mangosapp.ui.component.SubHeader
import com.unifae.lucas.mangosapp.ui.theme.MangosAppTheme

@Composable
fun CreateBankScreen(modifier: Modifier = Modifier) {
  var showValues by remember { mutableStateOf(true) }
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
          onBack = {}
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
          value = "",
          onChange = {}
        )
        FormInput(
          title = "Conta",
          placeholder = "Exemplo: 12345-6 ",
          value = "",
          onChange = {}
        )
        FormInput(
          title = "Agencia",
          placeholder = "Exemplo: 0000",
          value = "",
          onChange = {}
        )
        FormInput(
          title = "Titular",
          placeholder = "Exemplo: Fulano",
          value = "",
          onChange = {}
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
private fun CreateBankScreenPreview() {
  MangosAppTheme {
    CreateBankScreen()
  }
}
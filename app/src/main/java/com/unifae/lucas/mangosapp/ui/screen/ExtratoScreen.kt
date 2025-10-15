package com.unifae.lucas.mangosapp.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.unifae.lucas.mangosapp.ui.component.BodyCard
import com.unifae.lucas.mangosapp.ui.component.Footer
import com.unifae.lucas.mangosapp.ui.component.Result
import com.unifae.lucas.mangosapp.ui.component.ScreenHeader
import com.unifae.lucas.mangosapp.ui.component.SearchBar
import com.unifae.lucas.mangosapp.ui.component.Transaction
import com.unifae.lucas.mangosapp.ui.theme.MangosAppTheme

@Composable
fun ExtratoScreen() {
  var showValues by remember { mutableStateOf(true) }

  Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
    Column(
      modifier = Modifier
        .padding(innerPadding)
        .padding(top = MangosAppTheme.sizing.md)
        .fillMaxSize(),
      verticalArrangement = Arrangement.SpaceBetween,
    ) {
      ScreenHeader(
        modifier = Modifier.padding(start = MangosAppTheme.sizing.md),
        title =  "Extrato",
        onBack = {}
      )
      BodyCard(
        modifier = Modifier.height(120.dp).padding(horizontal = MangosAppTheme.sizing.sm),
        title = null
      ) {
        Row(
          modifier = Modifier
            .fillMaxSize(),
          verticalAlignment = Alignment.CenterVertically,
          horizontalArrangement = Arrangement.SpaceEvenly
        ){
          Result(
            value = 3333.33f,
            showValues = showValues,
          )
          Result(
            value = -3333.33f,
            showValues = showValues,
          )
        }
      }

      SearchBar(
        modifier = Modifier.padding(horizontal = MangosAppTheme.sizing.sm),
        placeholder = "Buscar",
        onChange = {}
      )

      Column(
        modifier = Modifier.padding(MangosAppTheme.sizing.sm).fillMaxHeight(.8f),
        Arrangement.spacedBy(MangosAppTheme.sizing.md)
      ) {
        Transaction(
          description = "Talia Silva",
          time = "18:30",
          type = "PIX",
          value = 1500f
        )
        Transaction(
          description = "Josias Henrique",
          time = "15:30",
          type = "PIX",
          value = -300f
        )
        Transaction(
          description = "Crunchyrool",
          time = "15:30",
          type = "Nubank Crédito",
          value = 1500f
        )
        Transaction(
          description = "Lucas Luiz",
          time = "21:13",
          type = "PIX",
          value = 23.33f
        )
        Transaction(
          description = "Geovane Alvaro",
          time = "21:13",
          type = "PIX",
          value = -250f
        )
      }

      Footer(
        selected = 1,
        onClick = {}
      )
    }
  }
}

@Preview
@Composable
private fun ExtratoScreenPreview() {
  MangosAppTheme {
    ExtratoScreen()
  }
}


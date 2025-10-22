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
import com.unifae.lucas.mangosapp.ui.component.Footer
import com.unifae.lucas.mangosapp.ui.component.MetaCard
import com.unifae.lucas.mangosapp.ui.component.ScreenHeader
import com.unifae.lucas.mangosapp.ui.theme.MangosAppTheme

@Composable
fun MetaScreen(modifier: Modifier = Modifier) {
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
        title =  "Metas",
        onBack = {}
      )
      Column(
        modifier = Modifier.fillMaxHeight(.85f),
        verticalArrangement = Arrangement.spacedBy(MangosAppTheme.sizing.md)
      ){
        MetaCard(
          categoria = "Alimentação",
          meta = 1000f,
          atingido = 500f,
        )
        MetaCard(
          categoria = "Saúde",
          meta = 800f,
          atingido = 500f,
        )
        MetaCard(
          categoria = "Lazer",
          meta = 500f,
          atingido = 460f,
        )
      }
      Footer(
        selected = 1,
        onClick = {}
      )
    }
  }
}

@PreviewLightDark
@Composable
private fun MetaScreenPreview() {
  MangosAppTheme {
    MetaScreen()
  }
}
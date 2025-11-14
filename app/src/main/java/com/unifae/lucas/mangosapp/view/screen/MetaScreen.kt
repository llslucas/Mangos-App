package com.unifae.lucas.mangosapp.view.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
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
import com.unifae.lucas.mangosapp.view.component.Footer
import com.unifae.lucas.mangosapp.view.component.MetaCard
import com.unifae.lucas.mangosapp.view.component.NewCategory
import com.unifae.lucas.mangosapp.view.component.ScreenHeader
import com.unifae.lucas.mangosapp.view.theme.MangosAppTheme
import com.unifae.lucas.mangosapp.viewmodel.MetaScreenViewModel

@Composable
fun MetaScreen(
  modifier: Modifier = Modifier,
  viewModel: MetaScreenViewModel = viewModel(),
  onChangeToHome: () -> Unit = {} ,
  onChangeToExtrato: () -> Unit = {},
  onChangeToNewCategory: () -> Unit = {}
) {
  val uiState = viewModel.uiState.collectAsState()

  Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
    Column(
      modifier = Modifier
        .padding(innerPadding)
        .padding(
          top = MangosAppTheme.sizing.md
        )
        .fillMaxSize(),
      verticalArrangement = Arrangement.SpaceBetween,
    ) {
      ScreenHeader(
        modifier = Modifier.padding(start = MangosAppTheme.sizing.md),
        title =  "Metas/Categorias",
        onBack = {
          onChangeToHome()
        }
      )
      Column(
        modifier = Modifier.
          fillMaxHeight(.85f)
          .padding(horizontal = MangosAppTheme.sizing.sm),
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
        NewCategory(
          onClick = {
            onChangeToNewCategory()
          }
        )
      }
      Footer(
        selected = 3,
        onClick = { button ->
          when (button) {
            1 -> onChangeToExtrato()
            2 -> onChangeToHome()
          }
        }
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
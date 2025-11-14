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

/**
 * Tela de metas e categorias, exibindo progresso de metas e opção para criar nova categoria.
 *
 * @param modifier Modifier opcional aplicado ao Scaffold.
 * @param viewModel ViewModel para gerenciar estado.
 * @param onChangeToHome Função para navegar à tela inicial.
 * @param onChangeToExtrato Função para navegar à tela de extrato.
 * @param onChangeToNewCategory Função para navegar à tela de criação de categoria.
 *
 * Uso: tela para visualizar e gerenciar metas de despesa por categoria.
 */
@Composable
fun MetaScreen(
  modifier: Modifier = Modifier,
  viewModel: MetaScreenViewModel = viewModel(),
  onChangeToHome: () -> Unit = {} ,
  onChangeToExtrato: () -> Unit = {},
  onChangeToNewCategory: () -> Unit = {}
) {
  // Coleta o estado da UI do ViewModel
  val uiState = viewModel.uiState.collectAsState()

  // Scaffold para estrutura básica da tela
  Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
    // Coluna principal dividindo cabeçalho, lista de metas e footer
    Column(
      modifier = Modifier
        .padding(innerPadding)
        .padding(
          top = MangosAppTheme.sizing.md
        )
        .fillMaxSize(),
      verticalArrangement = Arrangement.SpaceBetween,
    ) {
      // Cabeçalho com botão de voltar
      ScreenHeader(
        modifier = Modifier.padding(start = MangosAppTheme.sizing.md),
        title =  "Metas/Categorias",
        onBack = {
          onChangeToHome()
        }
      )
      // Coluna com lista de MetaCard e NewCategory
      Column(
        modifier = Modifier.
          fillMaxHeight(.85f)
          .padding(horizontal = MangosAppTheme.sizing.sm),
        verticalArrangement = Arrangement.spacedBy(MangosAppTheme.sizing.md)
      ){
        // MetaCard para Alimentação
        MetaCard(
          categoria = "Alimentação",
          meta = 1000f,
          atingido = 500f,
        )
        // MetaCard para Saúde
        MetaCard(
          categoria = "Saúde",
          meta = 800f,
          atingido = 500f,
        )
        // MetaCard para Lazer
        MetaCard(
          categoria = "Lazer",
          meta = 500f,
          atingido = 460f,
        )
        // Componente para criar nova categoria
        NewCategory(
          onClick = {
            onChangeToNewCategory()
          }
        )
      }
      // Footer de navegação
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

/**
 * Preview da MetaScreen.
 * Mostra a tela dentro do tema da aplicação.
 */
@PreviewLightDark
@Composable
private fun MetaScreenPreview() {
  MangosAppTheme {
    MetaScreen()
  }
}
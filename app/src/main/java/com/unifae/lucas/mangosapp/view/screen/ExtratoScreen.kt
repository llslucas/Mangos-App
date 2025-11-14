package com.unifae.lucas.mangosapp.view.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.unifae.lucas.mangosapp.view.component.BodyCard
import com.unifae.lucas.mangosapp.view.component.Footer
import com.unifae.lucas.mangosapp.view.component.Result
import com.unifae.lucas.mangosapp.view.component.ScreenHeader
import com.unifae.lucas.mangosapp.view.component.SearchBar
import com.unifae.lucas.mangosapp.view.component.Transaction
import com.unifae.lucas.mangosapp.view.theme.MangosAppTheme
import com.unifae.lucas.mangosapp.view.theme.Typography
import com.unifae.lucas.mangosapp.viewmodel.CreateTransactionViewModel
import com.unifae.lucas.mangosapp.viewmodel.ExtratoScreenEvent
import com.unifae.lucas.mangosapp.viewmodel.ExtratoScreenViewModel

/**
 * Tela de extrato, exibindo receitas/despesas, barra de busca e lista de transações agrupadas por data.
 *
 * @param viewModel ViewModel para gerenciar estado e eventos.
 * @param onChangeToHome Função para navegar à tela inicial.
 * @param onChangeToMetas Função para navegar à tela de metas.
 *
 * Uso: tela para visualizar histórico de transações com filtros e navegação.
 */
@Composable
fun ExtratoScreen(
  viewModel: ExtratoScreenViewModel = viewModel(),
  onChangeToHome: () -> Unit = {},
  onChangeToMetas: () -> Unit = {}
) {
  // Coleta o estado da UI do ViewModel
  val uiState by viewModel.uiState.collectAsState()

  // Scaffold para estrutura básica da tela
  Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
    // Coluna principal dividindo cabeçalho, resultados, busca, transações e footer
    Column(
      modifier = Modifier
        .padding(innerPadding)
        .padding(top = MangosAppTheme.sizing.md)
        .fillMaxSize(),
      verticalArrangement = Arrangement.SpaceBetween,
    ) {
      // Cabeçalho com botão de voltar
      ScreenHeader(
        modifier = Modifier.padding(start = MangosAppTheme.sizing.md),
        title =  "Extrato",
        onBack = {onChangeToHome()}
      )
      // BodyCard com receitas e despesas totais
      BodyCard(
        modifier = Modifier.height(120.dp).padding(horizontal = MangosAppTheme.sizing.sm),
        title = null
      ) {
        // Row com resultados lado a lado
        Row(
          modifier = Modifier
            .fillMaxSize(),
          verticalAlignment = Alignment.CenterVertically,
          horizontalArrangement = Arrangement.SpaceEvenly
        ){
          Result(
            value = 3333.33f,
            showValues = uiState.showValues,
          )
          Result(
            value = -3333.33f,
            showValues = uiState.showValues,
          )
        }
      }

      // Barra de busca para filtrar transações
      SearchBar(
        modifier = Modifier.padding(horizontal = MangosAppTheme.sizing.sm),
        placeholder = "Buscar",
        value = uiState.searchValue,
        onChange = { newValue ->
          viewModel.onEvent(ExtratoScreenEvent.SearchValueChanged(newValue))
        }
      )

      // Coluna com lista de transações agrupadas por data
      Column(
        modifier = Modifier
          .padding(MangosAppTheme.sizing.sm).
          fillMaxHeight(.8f)
        ,Arrangement
          .spacedBy(MangosAppTheme.sizing.md),
        horizontalAlignment = Alignment.Start
      ) {
        // Texto de data "Hoje"
        Text(
          text="Hoje",
          style= Typography.bodyMedium,
          color= MaterialTheme.colorScheme.onPrimary
        )
        // Transações de hoje
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
        // Texto de data "25 Set"
        Text(
          text="25 Set",
          style= Typography.bodyMedium,
          color= MaterialTheme.colorScheme.onPrimary
        )
        // Transações de 25 Set
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
      // Footer de navegação
      Footer(
        selected = 1,
        onClick = { button ->
          when (button) {
            2 -> onChangeToHome()
            3 -> onChangeToMetas()
          }
        }
      )
    }
  }
}

/**
 * Preview da ExtratoScreen.
 * Mostra a tela dentro do tema da aplicação.
 */
@PreviewLightDark
@Composable
private fun ExtratoScreenPreview() {
  MangosAppTheme {
    ExtratoScreen()
  }
}


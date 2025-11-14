package com.unifae.lucas.mangosapp.view.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.unifae.lucas.mangosapp.view.theme.MangosAppTheme
import com.unifae.lucas.mangosapp.view.theme.Typography

/**
 * Composable que exibe um cabeçalho de tela com botão de voltar, título centralizado e espaçador à direita.
 *
 * @param modifier Modifier opcional aplicado ao Row.
 * @param title Texto do título exibido no centro.
 * @param onBack Função lambda executada ao clicar no botão de voltar.
 *
 * Uso: cabeçalho padrão para telas com navegação de retorno, mantendo título centralizado.
 */
@Composable
fun ScreenHeader(modifier: Modifier = Modifier, title: String, onBack: () -> Unit) {
  // Layout horizontal para botão, título e espaçador, ocupando largura total
  Row(
    modifier = modifier.fillMaxWidth(),
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.SpaceBetween,
  ) {
    // Botão de ícone para voltar, com tamanho do tema
    IconButton(
      modifier = Modifier.size(MangosAppTheme.sizing.lg),
      onClick = {
        onBack()
      }
    ) {
      Icon(
        modifier = Modifier.size(MangosAppTheme.sizing.lg),
        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
        contentDescription = null,
        tint = MaterialTheme.colorScheme.onBackground
      )
    }

    // Título centralizado
    Text(
      text = title,
      style = Typography.headlineLarge,
      color = MaterialTheme.colorScheme.onBackground
    )
    // Espaçador invisível para equilibrar o layout
    Spacer(
      modifier.size(MangosAppTheme.sizing.lg)
    )
  }
}

/**
 * Preview do ScreenHeader com título "Extrato".
 * Mostra o componente dentro do tema da aplicação.
 */
@PreviewLightDark
@Composable
private fun ScreenHeaderPreview() {
  MangosAppTheme {
    ScreenHeader(
      title = "Extrato",
      onBack = {}
    )
  }
}
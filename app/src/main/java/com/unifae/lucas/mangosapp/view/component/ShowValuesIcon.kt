package com.unifae.lucas.mangosapp.view.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults.iconButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.unifae.lucas.mangosapp.view.theme.MangosAppTheme

/**
 * Composable que exibe um botão de ícone para alternar a visibilidade de valores (olho aberto/fechado).
 *
 * @param modifier Modifier opcional aplicado ao IconButton.
 * @param showValues Estado atual: true para mostrar valores, false para ocultar.
 * @param onClick Função lambda executada ao clicar no botão.
 *
 * Uso: botão de toggle para ocultar/mostrar valores monetários em telas de finanças.
 */
@Composable
fun ShowValuesIcon(modifier: Modifier = Modifier, showValues: Boolean, onClick:() -> Unit) {
  // Botão de ícone com cor baseada no tema
  IconButton(
    modifier = modifier,
    onClick = {
      onClick()
    },
    colors = iconButtonColors(
      contentColor = MaterialTheme.colorScheme.onBackground
    )

  ) {
    // Ícone muda baseado em showValues: olho aberto se true, fechado se false
    Icon(
      imageVector = if (showValues) {
        Icons.Default.Visibility
      } else {
        Icons.Default.VisibilityOff
      },
      contentDescription = null
    )
  }
}

/**
 * Preview do ShowValuesIcon com showValues true.
 * Mostra o componente dentro do tema da aplicação.
 */
@PreviewLightDark
@Composable
private fun ShowValuesIconPreview() {
  MangosAppTheme {
    ShowValuesIcon(
      showValues = true,
      onClick = {}
    )
  }
}
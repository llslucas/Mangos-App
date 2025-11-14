package com.unifae.lucas.mangosapp.view.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cottage
import androidx.compose.material.icons.filled.RequestPage
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.unifae.lucas.mangosapp.R
import com.unifae.lucas.mangosapp.view.theme.MangosAppTheme
import com.unifae.lucas.mangosapp.view.theme.Primary

/**
 * Composable que exibe uma barra de navegação inferior com três ícones clicáveis (página de solicitações, casa, troféu).
 * O ícone selecionado é destacado com a cor Primary.
 *
 * @param modifier Modifier opcional aplicado ao Row.
 * @param selected Índice do ícone atualmente selecionado (1, 2 ou 3).
 * @param onClick Função lambda chamada ao clicar em um ícone, passando o índice selecionado.
 *
 * Uso: barra de navegação para alternar entre telas principais do app.
 */
@Composable
fun Footer(modifier: Modifier = Modifier, selected: Int, onClick: (selected: Int) -> Unit) {
  // Layout horizontal para os ícones de navegação, com fundo e padding do tema
  Row(
    modifier = modifier
      .background(color = MaterialTheme.colorScheme.surface)
      .height(MangosAppTheme.sizing.x2l)
      .padding(vertical = MangosAppTheme.sizing.sm, horizontal = MangosAppTheme.sizing.lg)
      .fillMaxWidth(),
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.SpaceBetween,
  ) {
    // Primeiro ícone: página de solicitações
    IconButton(
      modifier = Modifier
        .fillMaxHeight()
        .aspectRatio(1f),
      onClick = {
        onClick(1)
      }
    ) {
      Icon(
        modifier = Modifier.aspectRatio(1f),
        imageVector = Icons.Default.RequestPage,
        contentDescription = null,
        tint = if (selected == 1) Primary else LocalContentColor.current
      )
    }

    // Segundo ícone: casa
    IconButton(
      modifier = Modifier
        .fillMaxHeight()
        .aspectRatio(1f),
      onClick = {
        onClick(2)
      }
    ) {
      Icon(
        modifier = Modifier.aspectRatio(1f),
        imageVector = Icons.Default.Cottage,
        contentDescription = null,
        tint = if (selected == 2) Primary else LocalContentColor.current
      )
    }

    // Terceiro ícone: troféu (usando painterResource)
    IconButton(
      modifier = Modifier
        .fillMaxHeight()
        .aspectRatio(1f),
      onClick = {
        onClick(3)
      }
    ) {
      Icon(
        modifier = Modifier.aspectRatio(1f),
        painter = painterResource(R.drawable.trophy),
        contentDescription = null,
        tint = if (selected == 3) Primary else LocalContentColor.current
      )
    }
  }
}

/**
 * Preview do Footer com o segundo ícone selecionado.
 * Mostra o componente dentro do tema da aplicação.
 */
@PreviewLightDark
@Composable
private fun FooterPreview() {
  MangosAppTheme {
    Footer(
      selected = 2,
      onClick = { selected ->
        print(selected)
      }
    )
  }
}
package com.unifae.lucas.mangosapp.view.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.unifae.lucas.mangosapp.view.theme.MangosAppTheme
import com.unifae.lucas.mangosapp.view.theme.Typography

/**
 * Composable que exibe um subtítulo simples em uma coluna, ocupando largura total.
 *
 * @param modifier Modifier opcional aplicado ao Column.
 * @param title Texto do subtítulo a ser exibido.
 *
 * Uso: cabeçalho secundário ou texto de ajuda em seções de tela.
 */
@Composable
fun SubHeader(
  modifier: Modifier = Modifier,
  title: String
) {
  // Layout vertical simples para o texto, ocupando largura total
  Column(
    modifier = modifier.fillMaxWidth()
  ) {
    // Texto do subtítulo com estilo pequeno
    Text(
      text = title,
      style = Typography.titleSmall,
      color = MaterialTheme.colorScheme.onBackground
    )
  }
}

/**
 * Preview do SubHeader com exemplo de texto de ajuda.
 * Mostra o componente dentro do tema da aplicação.
 */
@PreviewLightDark
@Composable
private fun SubHeaderPreview() {
  MangosAppTheme {
    SubHeader(
      title = "Text de ajuda para a página",
    )
  }
}
package com.unifae.lucas.mangosapp.view.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.unifae.lucas.mangosapp.view.theme.MangosAppTheme
import com.unifae.lucas.mangosapp.view.theme.Typography

/**
 * Composable que exibe um título opcional e um Card com conteúdo interno.
 *
 * @param modifier Modifier opcional aplicado ao contêiner externo.
 * @param title Texto opcional exibido acima do Card. Se for null, o título é omitido.
 * @param content Slot composable que representa o conteúdo interno do Card.
 *
 * Uso: fornece uma área visual consistente (title + card) que aplica estilos e espaçamentos do tema.
 */
@Composable
fun BodyCard(modifier: Modifier = Modifier, title: String?, content: @Composable () -> Unit) {
  // Layout vertical que separa o título do card usando o espaçamento do tema
  Column(
    modifier = modifier,
    verticalArrangement = Arrangement.spacedBy(MangosAppTheme.sizing.sm)
  ) {
    // Título opcional — renderiza somente se fornecido
    if(title != null) {
      Text(
        modifier = Modifier.padding(start = MangosAppTheme.sizing.md),
        text = title,
        style = Typography.headlineLarge,
        color = MaterialTheme.colorScheme.onBackground
      )
    }

    // Card principal que contém o conteúdo passado via slot
    Card(
      modifier = Modifier
        .fillMaxSize(),
      shape = RoundedCornerShape(10), // cantos arredondados para consistência visual
      colors = CardDefaults.cardColors(
        MaterialTheme.colorScheme.surface // cor de fundo do card baseada no tema
      )
    ) {
      // Container para o conteúdo do consumidor do composable
      content()
    }
  }
}

/**
 * Preview do BodyCard com exemplo mínimo.
 * Mostra o componente dentro do tema da aplicação.
 */
@PreviewLightDark
@Composable
private fun BodyCardPreview() {
  MangosAppTheme {
    BodyCard(
      title = "Despesas por Categoria",
    ) {}
  }
}
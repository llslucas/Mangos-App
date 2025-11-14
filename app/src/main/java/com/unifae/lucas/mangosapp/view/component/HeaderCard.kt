package com.unifae.lucas.mangosapp.view.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.unifae.lucas.mangosapp.view.theme.MangosAppTheme

/**
 * Composable que exibe um Card com bordas arredondadas apenas na parte inferior, usado para cabeçalhos.
 *
 * @param modifier Modifier opcional aplicado ao Card.
 * @param content Slot composable que representa o conteúdo interno do Card.
 *
 * Uso: container visual para seções de cabeçalho em telas, com forma arredondada inferior.
 */
@Composable
fun HeaderCard(modifier: Modifier = Modifier, content: @Composable () -> Unit) {
  // Card com largura total e forma arredondada apenas nas bordas inferiores
  Card(
    modifier = modifier
      .fillMaxWidth(),
    shape = RoundedCornerShape(
      topStartPercent = 0, // sem arredondamento no topo
      topEndPercent = 0,
      bottomEndPercent = 10, // arredondamento de 10% nas bordas inferiores
      bottomStartPercent = 10
    ),
    colors = CardDefaults.cardColors(
      MaterialTheme.colorScheme.surface // cor de fundo baseada no tema
    )
  ) {
    // Container para o conteúdo passado via slot
    content()
  }
}

/**
 * Preview do HeaderCard com conteúdo vazio.
 * Mostra o componente dentro do tema da aplicação.
 */
@PreviewLightDark
@Composable
private fun HeaderCardPreview() {
  MangosAppTheme {
    HeaderCard {}
  }
}
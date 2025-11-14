package com.unifae.lucas.mangosapp.view.component

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.unifae.lucas.mangosapp.view.theme.MangosAppTheme
import com.unifae.lucas.mangosapp.view.theme.Primary
import com.unifae.lucas.mangosapp.view.theme.Secondary
import com.unifae.lucas.mangosapp.view.theme.Typography
import kotlin.math.absoluteValue

/**
 * Composable que exibe um Card com informações de meta de despesa, incluindo progresso linear, valores e percentual.
 *
 * @param modifier Modifier opcional aplicado ao Column externo.
 * @param categoria Nome da categoria da meta.
 * @param meta Valor total da meta em reais.
 * @param atingido Valor já atingido em reais.
 *
 * Uso: exibir progresso de metas em dashboards financeiros, com indicador visual e cores baseadas no progresso.
 */
@SuppressLint("DefaultLocale")
@Composable
fun MetaCard(modifier: Modifier = Modifier, categoria: String, meta: Float, atingido: Float) {
  // Calcula o percentual de progresso (atingido / meta)
  val percent = atingido/meta

  // Layout vertical para o Card, com espaçamento do tema
  Column(
    modifier = modifier
    ,verticalArrangement = Arrangement.spacedBy(MangosAppTheme.sizing.sm)
  ) {
    // Card principal com altura fixa e bordas arredondadas
    Card(
      modifier = Modifier
        .fillMaxWidth()
        .height(140.dp)
      ,shape = RoundedCornerShape(10),
      colors = CardDefaults.cardColors(
        MaterialTheme.colorScheme.surface
      )
    ) {
      // Coluna interna com padding e alinhamento
      Column(
        modifier=Modifier
          .padding(MangosAppTheme.sizing.md)
          .fillMaxSize()
        ,verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.Start
      ) {
        // Texto da categoria
        Text(
          text = categoria,
          style = Typography.bodyMedium,
          color = MaterialTheme.colorScheme.onBackground
        )
        // Coluna para barra de progresso e valores
        Column(
          verticalArrangement = Arrangement.spacedBy(MangosAppTheme.sizing.xs)
        ) {
          // Barra de progresso linear, cor muda se >90%
          LinearProgressIndicator(
            progress = { percent },
            modifier = Modifier.fillMaxWidth().height(MangosAppTheme.sizing.sm),
            gapSize = 0.dp,
            color = if (percent > 0.9) Secondary else Primary,
            drawStopIndicator = {}
          )
          // Row com valor atingido e percentual
          Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
          ){
            Text(
              text = "R$ ${String.format("%.2f", atingido.absoluteValue)}",
              style = Typography.bodyMedium,
              color = MaterialTheme.colorScheme.onBackground
            )
            Text(
              text = "${String.format("%.2f", percent.absoluteValue * 100)}%",
              style = Typography.bodyMedium,
              color = MaterialTheme.colorScheme.onBackground
            )
          }
        }
        
        // Texto da meta total
        Text(
          text = "Meta: R$ ${String.format("%.2f", meta.absoluteValue)}",
          style = Typography.bodyMedium
        )
      }
    }
  }
}

/**
 * Preview do MetaCard com exemplo de categoria "Alimentação".
 * Mostra o componente dentro do tema da aplicação.
 */
@PreviewLightDark
@Composable
private fun MetaCardPreview() {
  MangosAppTheme{
    MetaCard(
      categoria = "Alimentação",
      meta = 1000f,
      atingido = 901f,
    )
  }
}
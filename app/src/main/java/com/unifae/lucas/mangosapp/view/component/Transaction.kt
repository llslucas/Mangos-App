package com.unifae.lucas.mangosapp.view.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.unifae.lucas.mangosapp.view.theme.MangosAppTheme
import com.unifae.lucas.mangosapp.view.theme.Primary
import com.unifae.lucas.mangosapp.view.theme.Secondary
import com.unifae.lucas.mangosapp.view.theme.Typography
import kotlin.math.absoluteValue

/**
 * Composable que exibe uma transação com ícone rotacionado (baseado no sinal do valor), descrição, horário, tipo e valor monetário.
 *
 * @param modifier Modifier opcional aplicado ao Row externo.
 * @param description Descrição da transação.
 * @param time Horário da transação (ex.: "33:33").
 * @param type Tipo da transação (ex.: "PIX").
 * @param value Valor numérico da transação (positivo ou negativo).
 *
 * Uso: item de lista para exibir transações em extratos ou históricos financeiros.
 */
@Composable
fun Transaction(modifier: Modifier = Modifier, description: String, time: String, type: String, value: Float) {
  // Layout horizontal para ícone e detalhes da transação, com altura fixa
  Row(
    modifier = modifier
      .fillMaxWidth()
      .height(50.dp)
    ,horizontalArrangement = Arrangement.spacedBy(MangosAppTheme.sizing.sm),
    verticalAlignment = Alignment.CenterVertically
  ) {
    // Ícone rotacionado e colorido baseado no sinal do valor: seta para cima se positivo, para baixo se negativo
    Icon(
      modifier = Modifier
        .rotate(if (value >= 0) -135f else 45f) // rotação para indicar direção (receita/despesa)
        .fillMaxHeight()
        .aspectRatio(1f)
        .background(color = MaterialTheme.colorScheme.surface, shape = CircleShape)
        .padding(MangosAppTheme.sizing.xs)
      , imageVector = Icons.AutoMirrored.Filled.ArrowBack,
      contentDescription = null,
      tint = if (value >= 0 ) Primary else Secondary // cor baseada no sinal
    )

    // Row interna com detalhes à esquerda e valor à direita
    Row(
      modifier = Modifier.fillMaxWidth(),
      horizontalArrangement = Arrangement.SpaceBetween,
      verticalAlignment = Alignment.CenterVertically
    ) {
      // Coluna com descrição e linha de tempo/tipo
      Column(
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(MangosAppTheme.sizing.xs)
      ) {
        // Descrição da transação
        Text(
          text = description,
          style = Typography.headlineMedium,
          color = MaterialTheme.colorScheme.onBackground
        )
        // Row com horário, separador e tipo
        Row(
          horizontalArrangement = Arrangement.spacedBy(MangosAppTheme.sizing.xs)
        ) {
          Text(
            text = time,
            style = Typography.headlineSmall,
            color = MaterialTheme.colorScheme.onBackground
          )
          Text(
            text = "-",
            style = Typography.headlineSmall,
            color = MaterialTheme.colorScheme.onBackground
          )
          Text(
            text = type,
            style = Typography.headlineSmall,
            color = MaterialTheme.colorScheme.onBackground
          )
        }
      }
      // Valor monetário formatado à direita
      Text(
        text = "R$ ${String.format("%.2f", value.absoluteValue)}",
        style = Typography.headlineMedium,
        color = MaterialTheme.colorScheme.onBackground
      )
    }
  }
}

/**
 * Preview do Transaction com exemplo de transação positiva.
 * Mostra o componente dentro do tema da aplicação.
 */
@PreviewLightDark
@Composable
private fun TransactionPreview() {
  MangosAppTheme {
    Transaction(
      description = "Descrição",
      time = "33:33",
      type = "PIX",
      value = 3333.33f
    )
  }
}
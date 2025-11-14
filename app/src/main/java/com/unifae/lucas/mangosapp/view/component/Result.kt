package com.unifae.lucas.mangosapp.view.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowCircleDown
import androidx.compose.material.icons.filled.ArrowCircleUp
import androidx.compose.material3.Icon
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

/**
 * Composable que exibe um resultado financeiro com ícone (seta para cima/baixo), texto ("Receitas" ou "Despesas") e valor monetário.
 *
 * @param modifier Modifier opcional aplicado ao Row.
 * @param value Valor numérico (positivo para receitas, negativo para despesas).
 * @param showValues Se true, mostra o valor; se false, oculta com traços.
 *
 * Uso: exibir resumos de receitas ou despesas em dashboards, com indicação visual baseada no sinal do valor.
 */
@Composable
fun Result(modifier: Modifier = Modifier, value: Float, showValues: Boolean) {
  // Determina ícone baseado no sinal: seta para cima se positivo (receitas), para baixo se negativo (despesas)
  val icon = if (value > 0) Icons.Default.ArrowCircleUp else Icons.Default.ArrowCircleDown
  // Cor baseada no sinal: Primary para receitas, Secondary para despesas
  val color = if (value > 0) Primary else Secondary
  // Texto baseado no sinal: "Receitas" ou "Despesas"
  val text = if (value > 0) "Receitas" else "Despesas"

  // Layout horizontal para ícone e texto vertical
  Row(
    modifier = modifier,
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.spacedBy(MangosAppTheme.sizing.sm)
  ) {
    // Ícone com tamanho fixo e cor dinâmica
    Icon(
      modifier = Modifier.size(43.dp),
      imageVector = icon,
      contentDescription = null,
      tint= color
    )
    // Coluna com texto do tipo e valor monetário
    Column {
      Text(
        text= text,
        style= Typography.headlineLarge,
        color= MaterialTheme.colorScheme.onBackground
      )
      CurrencyText(
        value = value,
        showValues = showValues,
        size = CurrencySize.MEDIUM
      )
    }
  }
}

/**
 * Preview do Result com exemplo de valor negativo (despesas).
 * Mostra o componente dentro do tema da aplicação.
 */
@PreviewLightDark
@Composable
private fun ResultPreview() {
  MangosAppTheme {
    Result(
      value= -3333.33f,
      showValues = true
    )
  }
}
package com.unifae.lucas.mangosapp.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowCircleDown
import androidx.compose.material.icons.filled.ArrowCircleUp
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.unifae.lucas.mangosapp.ui.theme.MangosAppTheme
import com.unifae.lucas.mangosapp.ui.theme.Primary
import com.unifae.lucas.mangosapp.ui.theme.Secondary
import com.unifae.lucas.mangosapp.ui.theme.Typography
import kotlin.math.absoluteValue

@Composable
fun Result(modifier: Modifier = Modifier, value: Float, showValues: Boolean) {
  val icon = if (value > 0) Icons.Default.ArrowCircleUp else Icons.Default.ArrowCircleDown
  val color = if (value > 0) Primary else Secondary
  val text = if (value > 0) "Receitas" else "Despesas"

  Row(
    modifier = modifier,
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.spacedBy(MangosAppTheme.sizing.sm)
  ) {
    Icon(
      modifier = Modifier.size(43.dp),
      imageVector = icon,
      contentDescription = null,
      tint= color
    )
    Column {
      Text(
        text= text,
        style= Typography.headlineLarge,
      )
      CurrencyText(
        value = value,
        showValues = showValues,
        size = CurrencySize.MEDIUM
      )
    }
  }
}

@Preview (showBackground = true)
@Composable
private fun ResultPreview() {
  MangosAppTheme {
    Result(
      value= -3333.33f,
      showValues = true
    )
  }
}
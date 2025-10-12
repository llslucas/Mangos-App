package com.unifae.lucas.mangosapp.ui.component

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import com.unifae.lucas.mangosapp.ui.theme.MangosAppTheme
import com.unifae.lucas.mangosapp.ui.theme.Primary
import com.unifae.lucas.mangosapp.ui.theme.Secondary
import com.unifae.lucas.mangosapp.ui.theme.Typography
import kotlin.math.absoluteValue

enum class CurrencySize(val style: TextStyle) {
  MEDIUM(Typography.bodyMedium),
  LARGE(Typography.bodyLarge);
}

@Composable
fun CurrencyText(modifier: Modifier = Modifier, value: Float, showValues: Boolean, size: CurrencySize) {
  val color = if (value > 0) Primary else Secondary
  val displayValue = if (showValues) value.absoluteValue.toString() else " - - - - - -"

  Text(
    modifier = modifier,
    text = "R$ $displayValue",
    color = color,
    style = size.style
  )
}

@Preview
@Composable
private fun CurrencyTextPreview() {
  MangosAppTheme {
    CurrencyText(
      value = -3333.33f,
      showValues = true,
      size = CurrencySize.LARGE
    )
  }
}
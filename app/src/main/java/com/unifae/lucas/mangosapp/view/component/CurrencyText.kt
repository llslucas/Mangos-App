package com.unifae.lucas.mangosapp.view.component

import android.annotation.SuppressLint
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import com.unifae.lucas.mangosapp.view.theme.MangosAppTheme
import com.unifae.lucas.mangosapp.view.theme.Primary
import com.unifae.lucas.mangosapp.view.theme.Secondary
import com.unifae.lucas.mangosapp.view.theme.Typography
import kotlin.math.absoluteValue

/**
 * Enum que define os tamanhos disponíveis para o texto de moeda, mapeando para estilos de tipografia.
 *
 * @param style Estilo de texto associado ao tamanho.
 */
enum class CurrencySize(val style: TextStyle) {
  MEDIUM(Typography.bodyMedium),
  LARGE(Typography.bodyLarge);
}

/**
 * Composable que exibe um valor monetário em reais (R$), com cor baseada no sinal (positivo = Primary, negativo = Secondary).
 * Permite ocultar valores reais substituindo por traços.
 *
 * @param modifier Modifier opcional aplicado ao Text.
 * @param value Valor numérico a ser exibido (positivo ou negativo).
 * @param showValues Se true, mostra o valor formatado; se false, exibe traços para ocultar.
 * @param size Tamanho do texto, definido pelo enum CurrencySize.
 *
 * Uso: ideal para exibir saldos ou valores financeiros com indicação visual de sinal.
 */
@SuppressLint("DefaultLocale")
@Composable
fun CurrencyText(modifier: Modifier = Modifier, value: Float, showValues: Boolean, size: CurrencySize) {
  // Define cor baseada no sinal do valor: positivo usa Primary, negativo usa Secondary
  val color = if (value > 0) Primary else Secondary
  // Formata o valor absoluto com duas casas decimais, ou substitui por traços se oculto
  val displayValue: String = if (showValues) String.format("%.2f", value.absoluteValue) else " - - - - - -"

  Text(
    modifier = modifier,
    text = "R$ $displayValue",
    color = color,
    style = size.style
  )
}

/**
 * Preview do CurrencyText com exemplo de valor negativo.
 * Mostra o componente dentro do tema da aplicação.
 */
@Preview
@Composable
private fun CurrencyTextPreview() {
  MangosAppTheme {
    CurrencyText(
      value = -3333.00f,
      showValues = true,
      size = CurrencySize.LARGE
    )
  }
}
package com.unifae.lucas.mangosapp.view.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBalance
import androidx.compose.material.icons.filled.MedicalServices
import androidx.compose.material.icons.filled.Restaurant
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.unifae.lucas.mangosapp.view.theme.DarkTextPrimary
import com.unifae.lucas.mangosapp.view.theme.MangosAppTheme
import com.unifae.lucas.mangosapp.view.theme.Primary
import com.unifae.lucas.mangosapp.view.theme.Typography

/**
 * Enum que define tipos de categorias de despesa, cada um associado a um ícone.
 *
 * @param icon Ícone vetorial representando a categoria.
 */
enum class ExpenseCategoryType(val icon: ImageVector) {
  BANK(Icons.Default.AccountBalance),
  FOOD(Icons.Default.Restaurant),
  HEALTH(Icons.Default.MedicalServices)
}

/**
 * Composable que exibe uma categoria de despesa com ícone, nome e valor monetário.
 *
 * @param modifier Modifier opcional aplicado ao Row.
 * @param type Tipo da categoria, que define o ícone.
 * @param name Nome da categoria exibido como texto.
 * @param value Valor numérico da despesa.
 * @param showValues Se true, mostra o valor; se false, oculta com traços.
 *
 * Uso: item de lista para exibir categorias de despesas em relatórios ou dashboards.
 */
@Composable
fun ExpenseCategory(
  modifier: Modifier = Modifier,
  type: ExpenseCategoryType,
  name: String,
  value: Float,
  showValues: Boolean,
) {
  // Layout horizontal que alinha ícone e texto verticalmente
  Row(
    modifier = modifier,
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.spacedBy(MangosAppTheme.sizing.sm)
  ) {
    // Ícone circular com fundo Primary e padding interno
    Icon(
      modifier = Modifier
        .size(40.dp)
        .background(color = Primary, shape = CircleShape)
        .padding(MangosAppTheme.sizing.xs),
      imageVector = type.icon,
      contentDescription = null,
      tint = DarkTextPrimary
    )
    // Coluna com nome da categoria e valor monetário
    Column {
      Text(
        text = name,
        style = Typography.headlineMedium,
        color = MaterialTheme.colorScheme.onBackground
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
 * Preview do ExpenseCategory com exemplo de categoria de comida.
 * Mostra o componente dentro do tema da aplicação.
 */
@PreviewLightDark
@Composable
private fun ExpenseCategoryPreview() {
  MangosAppTheme {
    ExpenseCategory(
      type = ExpenseCategoryType.FOOD,
      name = "Saúde",
      value = 3333.33f,
      showValues = true
    )
  }
}
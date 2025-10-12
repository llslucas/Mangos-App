package com.unifae.lucas.mangosapp.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBalance
import androidx.compose.material.icons.filled.MedicalServices
import androidx.compose.material.icons.filled.Restaurant
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.unifae.lucas.mangosapp.ui.theme.DarkTextPrimary
import com.unifae.lucas.mangosapp.ui.theme.MangosAppTheme
import com.unifae.lucas.mangosapp.ui.theme.Primary
import com.unifae.lucas.mangosapp.ui.theme.Typography

enum class ExpenseCategoryType(val icon: ImageVector) {
  BANK(Icons.Default.AccountBalance),
  FOOD(Icons.Default.Restaurant),
  HEALTH(Icons.Default.MedicalServices)
}

@Composable
fun ExpenseCategory(
  modifier: Modifier = Modifier,
  type: ExpenseCategoryType,
  name: String,
  value: Float,
  showValues: Boolean,
) {
  Row(
    modifier = modifier,
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.spacedBy(MangosAppTheme.sizing.sm)
  ) {
    Icon(
      modifier = Modifier
        .size(40.dp)
        .background(color = Primary, shape = CircleShape)
        .padding(MangosAppTheme.sizing.xs),
      imageVector = type.icon,
      contentDescription = null,
      tint = DarkTextPrimary
    )
    Column {
      Text(
        text = name,
        style = Typography.headlineMedium,
      )
      CurrencyText(
        value = value,
        showValues = showValues,
        size = CurrencySize.MEDIUM
      )
    }
  }
}

@Preview(showBackground = true)
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
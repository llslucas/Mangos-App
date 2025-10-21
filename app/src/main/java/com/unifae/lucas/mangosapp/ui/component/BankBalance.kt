package com.unifae.lucas.mangosapp.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircleOutline
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.unifae.lucas.mangosapp.R
import com.unifae.lucas.mangosapp.ui.theme.MangosAppTheme
import com.unifae.lucas.mangosapp.ui.theme.Primary
import com.unifae.lucas.mangosapp.ui.theme.Typography

enum class BankType(val icon: Int) {
  ITAU(R.drawable.itau_unibanco),
  NUBANK(R.drawable.nubank),
  SANTANDER(R.drawable.santander_brasil),
  BB(R.drawable.banco_do_brasil)
}

@Composable
fun BankBalance(modifier: Modifier = Modifier, name: String, value: Float, bankType: BankType, showValues: Boolean) {
  Row(
    modifier = modifier.fillMaxWidth(),
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.SpaceBetween
  ){
    Row(
      verticalAlignment = Alignment.CenterVertically,
      horizontalArrangement = Arrangement.spacedBy(MangosAppTheme.sizing.sm)
    ) {
      Icon(
        modifier = Modifier
          .size(42.dp)
          .padding(MangosAppTheme.sizing.xs)
          .clip(shape= CircleShape),
        painter= painterResource(bankType.icon),
        contentDescription = null,
        tint= Color.Unspecified
      )
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
    Icon(
      modifier = Modifier.size(42.dp),
      imageVector = Icons.Default.AddCircleOutline,
      contentDescription = null,
      tint = Primary
    )
  }
}

@PreviewLightDark
@Composable
private fun BankBalancePreview() {
  MangosAppTheme {
    BankBalance(
      value= 3333.33f,
      bankType = BankType.NUBANK,
      name= "Nubank",
      showValues = true
    )
  }
}
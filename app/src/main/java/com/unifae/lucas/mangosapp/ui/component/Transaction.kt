package com.unifae.lucas.mangosapp.ui.component

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.unifae.lucas.mangosapp.ui.theme.DarkSurface
import com.unifae.lucas.mangosapp.ui.theme.MangosAppTheme
import com.unifae.lucas.mangosapp.ui.theme.Primary
import com.unifae.lucas.mangosapp.ui.theme.Secondary
import com.unifae.lucas.mangosapp.ui.theme.Typography
import kotlin.math.absoluteValue

@Composable
fun Transaction(modifier: Modifier = Modifier, description: String, time: String, type: String, value: Float) {
  Row(
    modifier = modifier
      .fillMaxWidth()
      .height(50.dp)
    ,horizontalArrangement = Arrangement.spacedBy(MangosAppTheme.sizing.sm),
    verticalAlignment = Alignment.CenterVertically
  ) {
    Icon(
      modifier = Modifier
        .rotate(if (value >= 0) -135f else 45f)
        .fillMaxHeight()
        .aspectRatio(1f)
        .background(color = MaterialTheme.colorScheme.surface, shape = CircleShape)
        .padding(MangosAppTheme.sizing.xs)
      , imageVector = Icons.AutoMirrored.Filled.ArrowBack,
      contentDescription = null,
      tint = if (value >= 0 ) Primary else Secondary
    )

    Row(
      modifier = Modifier.fillMaxWidth(),
      horizontalArrangement = Arrangement.SpaceBetween,
      verticalAlignment = Alignment.CenterVertically
    ) {
      Column(
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(MangosAppTheme.sizing.xs)
      ) {
        Text(
          text = description,
          style = Typography.headlineMedium,
          color = MaterialTheme.colorScheme.onBackground
        )
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
      Text(
        text = "R$ ${String.format("%.2f", value.absoluteValue)}",
        style = Typography.headlineMedium,
        color = MaterialTheme.colorScheme.onBackground
      )
    }
  }
}

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
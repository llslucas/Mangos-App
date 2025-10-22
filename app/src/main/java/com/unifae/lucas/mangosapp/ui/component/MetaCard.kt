package com.unifae.lucas.mangosapp.ui.component

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
import com.unifae.lucas.mangosapp.ui.theme.MangosAppTheme
import com.unifae.lucas.mangosapp.ui.theme.Primary
import com.unifae.lucas.mangosapp.ui.theme.Secondary
import com.unifae.lucas.mangosapp.ui.theme.Typography
import kotlin.math.absoluteValue

@SuppressLint("DefaultLocale")
@Composable
fun MetaCard(modifier: Modifier = Modifier, categoria: String, meta: Float, atingido: Float) {
  val percent = atingido/meta

  Column(
    modifier = modifier
    ,verticalArrangement = Arrangement.spacedBy(MangosAppTheme.sizing.sm)
  ) {
    Card(
      modifier = Modifier
        .fillMaxWidth()
        .height(140.dp)
      ,shape = RoundedCornerShape(10),
      colors = CardDefaults.cardColors(
        MaterialTheme.colorScheme.surface
      )
    ) {
      Column(
        modifier=Modifier
          .padding(MangosAppTheme.sizing.md)
          .fillMaxSize()
        ,verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.Start
      ) {
        Text(
          text = categoria,
          style = Typography.bodyMedium,
          color = MaterialTheme.colorScheme.onBackground
        )
        Column(
          verticalArrangement = Arrangement.spacedBy(MangosAppTheme.sizing.xs)
        ) {
          LinearProgressIndicator(
            progress = { percent },
            modifier = Modifier.fillMaxWidth().height(MangosAppTheme.sizing.sm),
            gapSize = 0.dp,
            color = if (percent > 0.9) Secondary else Primary,
            drawStopIndicator = {}
          )
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
        
        Text(
          text = "Meta: R$ ${String.format("%.2f", meta.absoluteValue)}",
          style = Typography.bodyMedium
        )
      }
    }
  }
}

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
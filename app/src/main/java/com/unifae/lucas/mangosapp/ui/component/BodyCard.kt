package com.unifae.lucas.mangosapp.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.unifae.lucas.mangosapp.ui.theme.MangosAppTheme
import com.unifae.lucas.mangosapp.ui.theme.Typography

@Composable
fun BodyCard(modifier: Modifier = Modifier, title: String?, content: @Composable () -> Unit) {
  Column(
    modifier = modifier,
    verticalArrangement = Arrangement.spacedBy(MangosAppTheme.sizing.sm)
  ) {
    if(title != null) {
      Text(
        modifier = Modifier.padding(start = MangosAppTheme.sizing.md),
        text = title,
        style = Typography.headlineLarge,
        color = MaterialTheme.colorScheme.onBackground
      )
    }

    Card(
      modifier = Modifier
        .fillMaxSize(),
      shape = RoundedCornerShape(10),
      colors = CardDefaults.cardColors(
        MaterialTheme.colorScheme.surface
      )
    ) {
      content()
    }
  }
}

@PreviewLightDark
@Composable
private fun BodyCardPreview() {
  MangosAppTheme {
    BodyCard(
      title = "Despesas por Categoria",
    ) {}
  }
}
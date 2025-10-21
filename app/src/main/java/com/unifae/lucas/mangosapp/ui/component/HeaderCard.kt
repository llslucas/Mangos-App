package com.unifae.lucas.mangosapp.ui.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.unifae.lucas.mangosapp.ui.theme.MangosAppTheme

@Composable
fun HeaderCard(modifier: Modifier = Modifier, content: @Composable () -> Unit) {
  Card(
    modifier = modifier
      .fillMaxWidth()
      .height(210.dp),
    shape = RoundedCornerShape(
      topStartPercent = 0,
      topEndPercent = 0,
      bottomEndPercent = 10,
      bottomStartPercent = 10
    ),
    colors = CardDefaults.cardColors(
      MaterialTheme.colorScheme.surface
    )
  ) {
    content()
  }
}

@PreviewLightDark
@Composable
private fun HeaderCardPreview() {
  MangosAppTheme {
    HeaderCard {}
  }
}
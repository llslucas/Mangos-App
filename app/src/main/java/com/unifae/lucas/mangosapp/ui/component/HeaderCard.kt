package com.unifae.lucas.mangosapp.ui.component

import android.content.res.Configuration
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.unifae.lucas.mangosapp.ui.theme.MangosAppTheme

@Composable
fun HeaderCard(modifier: Modifier = Modifier, content: @Composable () -> Unit) {
  Card (
    modifier = modifier.fillMaxWidth().height(220.dp),
    shape = RoundedCornerShape(
      topStartPercent = 0,
      topEndPercent = 0,
      bottomEndPercent = 20,
      bottomStartPercent = 20
    )
  ) {
    content()
  }
}

@Preview (showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun HeaderCardPreview() {
  MangosAppTheme {
    HeaderCard {}
  }
}
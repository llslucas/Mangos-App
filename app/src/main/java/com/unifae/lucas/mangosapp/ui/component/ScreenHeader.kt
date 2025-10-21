package com.unifae.lucas.mangosapp.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.unifae.lucas.mangosapp.ui.theme.MangosAppTheme
import com.unifae.lucas.mangosapp.ui.theme.Typography

@Composable
fun ScreenHeader(modifier: Modifier = Modifier, title: String, onBack: () -> Unit) {
  Row(
    modifier = modifier.fillMaxWidth(),
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.SpaceBetween,
  ) {
    IconButton(
      modifier = Modifier.size(MangosAppTheme.sizing.lg),
      onClick = {
        onBack()
      }
    ) {
      Icon(
        modifier = Modifier.size(MangosAppTheme.sizing.lg),
        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
        contentDescription = null,
        tint = MaterialTheme.colorScheme.onBackground
      )
    }

    Text(
      text = title,
      style = Typography.headlineLarge,
      color = MaterialTheme.colorScheme.onBackground
    )
    Spacer(
      modifier.size(MangosAppTheme.sizing.lg)
    )
  }
}

@PreviewLightDark
@Composable
private fun ScreenHeaderPreview() {
  MangosAppTheme {
    ScreenHeader(
      title = "Extrato",
      onBack = {}
    )
  }
}
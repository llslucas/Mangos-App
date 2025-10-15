package com.unifae.lucas.mangosapp.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.unifae.lucas.mangosapp.ui.theme.DarkTextPrimary
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
        tint = DarkTextPrimary
      )
    }

    Text(
      text = title,
      style = Typography.headlineLarge,
      color = DarkTextPrimary
    )
    Spacer(
      modifier.size(MangosAppTheme.sizing.lg)
    )
  }
}

@Preview
@Composable
private fun ScreenHeaderPreview() {
  MangosAppTheme {
    ScreenHeader(
      title = "Extrato",
      onBack = {}
    )
  }
}
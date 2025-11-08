package com.unifae.lucas.mangosapp.view.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.unifae.lucas.mangosapp.view.theme.MangosAppTheme
import com.unifae.lucas.mangosapp.view.theme.Typography

@Composable
fun SubHeader(
  modifier: Modifier = Modifier,
  title: String
) {
  Column(
    modifier = modifier.fillMaxWidth()
  ) {
    Text(
      text = title,
      style = Typography.titleSmall,
      color = MaterialTheme.colorScheme.onBackground
    )
  }
}

@PreviewLightDark
@Composable
private fun SubHeaderPreview() {
  MangosAppTheme {
    SubHeader(
      title = "Text de ajuda para a página",
    )
  }
}
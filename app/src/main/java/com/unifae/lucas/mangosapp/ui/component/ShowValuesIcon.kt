package com.unifae.lucas.mangosapp.ui.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults.iconButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.unifae.lucas.mangosapp.ui.theme.DarkTextPrimary
import com.unifae.lucas.mangosapp.ui.theme.MangosAppTheme

@Composable
fun ShowValuesIcon(modifier: Modifier = Modifier, showValues: Boolean, onClick:() -> Unit) {
  IconButton(
    modifier = modifier,
    onClick = {
      onClick()
    },
    colors = iconButtonColors(
      contentColor = MaterialTheme.colorScheme.onBackground
    )

  ) {
    Icon(
      imageVector = if (showValues) {
        Icons.Default.Visibility
      } else {
        Icons.Default.VisibilityOff
      },
      contentDescription = null
    )
  }
}

@PreviewLightDark
@Composable
private fun ShowValuesIconPreview() {
  MangosAppTheme {
    ShowValuesIcon(
      showValues = true,
      onClick = {}
    )
  }
}
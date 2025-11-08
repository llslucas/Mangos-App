package com.unifae.lucas.mangosapp.view.component

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.unifae.lucas.mangosapp.view.theme.MangosAppTheme
import com.unifae.lucas.mangosapp.view.theme.Primary
import com.unifae.lucas.mangosapp.view.theme.Typography

@Composable
fun CustomButton(
  modifier: Modifier = Modifier,
  onClick: () -> Unit,
  text: String,
  bgColor: Color = Primary,
  textColor: Color = MaterialTheme.colorScheme.onBackground,
  ) {
  Button(
    modifier = modifier,
    onClick = onClick,
    colors = ButtonDefaults.buttonColors(
      containerColor = bgColor,
      contentColor = textColor,
    ),
    content = {
      Text(
        modifier = Modifier.padding(8.dp),
        text = text,
        style = Typography.bodyMedium
      )
    }
  )
}

@PreviewLightDark
@Composable
private fun CustomButtonPreview() {
  MangosAppTheme {
    CustomButton(
      text = "Botão",
      onClick = {}
    )
  }
}
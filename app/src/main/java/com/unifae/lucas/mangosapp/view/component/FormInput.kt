package com.unifae.lucas.mangosapp.view.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.unifae.lucas.mangosapp.view.theme.MangosAppTheme
import com.unifae.lucas.mangosapp.view.theme.Primary
import com.unifae.lucas.mangosapp.view.theme.Typography

@Composable
fun FormInput(
  modifier: Modifier = Modifier,
  title: String,
  placeholder: String,
  value: String,
  onChange: (text: String) -> Unit,
) {
  Column(
    modifier = modifier,
    Arrangement.spacedBy(MangosAppTheme.sizing.sm)
  ) {
    Text(
      text = title,
      style = Typography.headlineMedium,
      color = MaterialTheme.colorScheme.onBackground,
      modifier = Modifier.padding(start = MangosAppTheme.sizing.sm)
    )
    OutlinedTextField(
      modifier = Modifier.fillMaxWidth(),
      value = value,
      onValueChange = onChange,
      placeholder = {
        Text(
          text = placeholder,
          style = Typography.titleMedium,
          color = MaterialTheme.colorScheme.onSecondary
        )
      },
      shape = CircleShape,
      textStyle = Typography.titleMedium,
      colors = OutlinedTextFieldDefaults.colors(
        focusedBorderColor = Primary,
        focusedContainerColor = MaterialTheme.colorScheme.surface,
        focusedTextColor = MaterialTheme.colorScheme.onSurface,
        unfocusedBorderColor = Color.Transparent,
        unfocusedContainerColor = MaterialTheme.colorScheme.surface,
        unfocusedTextColor = MaterialTheme.colorScheme.onSurface
      )
    )
  }
}

@PreviewLightDark
@Composable
private fun FormInputPreview() {
  val (text, setText) = remember { mutableStateOf("") }

  MangosAppTheme {
    FormInput(
      title = "Título",
      placeholder = "Placeholder",
      value = text,
      onChange = setText
    )
  }
}
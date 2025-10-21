package com.unifae.lucas.mangosapp.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.unifae.lucas.mangosapp.ui.theme.DarkSurface
import com.unifae.lucas.mangosapp.ui.theme.DarkTextPrimary
import com.unifae.lucas.mangosapp.ui.theme.MangosAppTheme
import com.unifae.lucas.mangosapp.ui.theme.Typography

@Composable
fun SearchBar(modifier: Modifier = Modifier, placeholder: String, onChange: (value: String) -> Unit) {
  var value by remember { mutableStateOf("") }
  OutlinedTextField(
    shape = CircleShape,
    modifier = modifier.fillMaxWidth().background(color = MaterialTheme.colorScheme.surface, shape = CircleShape),
    value = value,
    onValueChange = { text ->
      value = text
      onChange(value)
    },
    leadingIcon = {
      Icon(
        modifier = Modifier.padding(start = MangosAppTheme.sizing.md),
        imageVector= Icons.Default.Search,
        contentDescription = null,
        tint = MaterialTheme.colorScheme.onBackground
      )
    },
    placeholder = {
      Text(
        text = placeholder,
        style = Typography.displayMedium,
        color = MaterialTheme.colorScheme.onBackground
      )
    },
    textStyle = Typography.displayMedium,
  )
}

@PreviewLightDark
@Composable
private fun SearchBarPreview() {
  MangosAppTheme {
    SearchBar(
      placeholder = "Buscar",
      onChange = {}
    )
  }
}
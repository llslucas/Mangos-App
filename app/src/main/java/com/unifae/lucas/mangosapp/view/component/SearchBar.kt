package com.unifae.lucas.mangosapp.view.component

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
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.unifae.lucas.mangosapp.view.theme.MangosAppTheme
import com.unifae.lucas.mangosapp.view.theme.Typography

/**
 * Composable que exibe uma barra de pesquisa com ícone de lupa, placeholder e campo de entrada arredondado.
 *
 * @param modifier Modifier opcional aplicado ao OutlinedTextField.
 * @param placeholder Texto exibido quando o campo está vazio.
 * @param value Valor atual do texto no campo.
 * @param onChange Função lambda chamada quando o texto muda.
 *
 * Uso: campo de busca em listas ou telas de pesquisa, com estilo arredondado e ícone integrado.
 */
@Composable
fun SearchBar(modifier: Modifier = Modifier, placeholder: String, value: String, onChange: (value: String) -> Unit) {
  // Campo de texto outlined com forma circular e fundo do tema
  OutlinedTextField(
    shape = CircleShape,
    modifier = modifier.fillMaxWidth().background(color = MaterialTheme.colorScheme.surface, shape = CircleShape),
    value = value,
    onValueChange = onChange,
    leadingIcon = {
      // Ícone de busca à esquerda, com padding
      Icon(
        modifier = Modifier.padding(start = MangosAppTheme.sizing.md),
        imageVector= Icons.Default.Search,
        contentDescription = null,
        tint = MaterialTheme.colorScheme.onBackground
      )
    },
    placeholder = {
      // Texto placeholder com estilo do tema
      Text(
        text = placeholder,
        style = Typography.displayMedium,
        color = MaterialTheme.colorScheme.onBackground
      )
    },
    textStyle = Typography.displayMedium,
  )
}

/**
 * Preview do SearchBar com placeholder "Buscar".
 * Mostra o componente dentro do tema da aplicação.
 */
@PreviewLightDark
@Composable
private fun SearchBarPreview() {
  MangosAppTheme {
    SearchBar(
      placeholder = "Buscar",
      value = "",
      onChange = {}
    )
  }
}
package com.unifae.lucas.mangosapp.view.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircleOutline
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.unifae.lucas.mangosapp.view.theme.MangosAppTheme
import com.unifae.lucas.mangosapp.view.theme.Primary
import com.unifae.lucas.mangosapp.view.theme.Typography

/**
 * Composable que exibe um Card clicável para criar uma nova categoria, com texto e ícone de adicionar.
 *
 * @param modifier Modifier opcional aplicado ao Card.
 * @param onClick Função lambda executada ao clicar no Card.
 *
 * Uso: item clicável em listas de categorias para permitir adição de novas categorias.
 */
@Composable
fun NewCategory(modifier: Modifier = Modifier, onClick: () -> Unit) {
  // Card clicável com altura fixa e bordas arredondadas
  Card(
    modifier = Modifier
      .fillMaxWidth()
      .height(140.dp)
      .clickable(
        onClick = onClick
      ),
    shape = RoundedCornerShape(10),
    colors = CardDefaults.cardColors(
      MaterialTheme.colorScheme.surface
    )
  ) {
    // Row interna centralizada com texto e ícone
    Row(
      modifier = Modifier
        .padding(MangosAppTheme.sizing.md)
        .fillMaxSize(),
      horizontalArrangement = Arrangement.Center,
      verticalAlignment = Alignment.CenterVertically
    ) {
      // Texto "Nova Categoria"
      Text(
        text = "Nova Categoria",
        style = Typography.bodyLarge,
        color = MaterialTheme.colorScheme.onBackground
      )
      // Espaçador entre texto e ícone
      Spacer(
        modifier = Modifier.width(MangosAppTheme.sizing.sm)
      )
      // Ícone de adicionar
      Icon(
        modifier = Modifier.size(36.dp),
        imageVector = Icons.Default.AddCircleOutline,
        contentDescription = null,
        tint = Primary
      )
    }
  }
}

/**
 * Preview do NewCategory com exemplo básico.
 * Mostra o componente dentro do tema da aplicação.
 */
@PreviewLightDark
@Composable
private fun MetaCardPreview() {
  MangosAppTheme {
    NewCategory(
      onClick = {}
    )
  }
}
package com.unifae.lucas.mangosapp.view.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircleOutline
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.unifae.lucas.mangosapp.R
import com.unifae.lucas.mangosapp.view.theme.MangosAppTheme
import com.unifae.lucas.mangosapp.view.theme.Primary
import com.unifae.lucas.mangosapp.view.theme.Typography

/**
 * Composable que exibe uma linha com texto "Criar novo banco" e um botão de ícone para adicionar.
 *
 * @param modifier Modifier opcional aplicado ao Row externo.
 * @param onClick Função lambda executada ao clicar no botão de adicionar.
 *
 * Uso: item de lista ou seção para permitir a criação de um novo banco em telas de gerenciamento financeiro.
 */
@Composable
fun NewBank(modifier: Modifier = Modifier, onClick: () -> Unit) {
  // Layout horizontal para texto e botão, ocupando largura total
  Row(
    modifier = modifier.fillMaxWidth(),
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.SpaceBetween
  ){
    // Row interna com texto, alinhado verticalmente
    Row(
      verticalAlignment = Alignment.CenterVertically,
      horizontalArrangement = Arrangement.spacedBy(MangosAppTheme.sizing.sm)
    ) {
      // Coluna com o texto do título
      Column {
        Text(
          text = "Criar novo banco",
          style = Typography.headlineMedium,
          color = MaterialTheme.colorScheme.onBackground
        )
      }
    }
    // Botão de ícone para adicionar, com tamanho personalizado
    IconButton(
      onClick = onClick,
    ) {
      Icon(
        modifier = Modifier.size(42.dp),
        imageVector = Icons.Default.AddCircleOutline,
        contentDescription = null,
        tint = Primary
      )
    }
  }
}

/**
 * Preview do NewBank com exemplo básico.
 * Mostra o componente dentro do tema da aplicação.
 */
@PreviewLightDark
@Composable
private fun BankBalancePreview() {
  MangosAppTheme {
    NewBank(
      onClick = {}
    )
  }
}
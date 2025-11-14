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

/**
 * Composable que cria um botão personalizado com texto, cores configuráveis e ação de clique.
 *
 * @param modifier Modifier opcional aplicado ao Button.
 * @param onClick Função lambda executada ao clicar no botão.
 * @param text Texto exibido dentro do botão.
 * @param bgColor Cor de fundo do botão (padrão: Primary).
 * @param textColor Cor do texto (padrão: onBackground do tema).
 *
 * Uso: botão reutilizável para ações na UI, com personalização de cores.
 */
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
      containerColor = bgColor, // cor de fundo personalizada
      contentColor = textColor, // cor do conteúdo (texto) personalizada
    ),
    content = {
      Text(
        modifier = Modifier.padding(8.dp), // padding interno para espaçamento do texto
        text = text,
        style = Typography.bodyMedium
      )
    }
  )
}

/**
 * Preview do CustomButton com exemplo básico.
 * Mostra o componente dentro do tema da aplicação.
 */
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
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
 * Representa os bancos suportados pelo componente `BankBalance`.
 *
 * Cada enum encapsula o recurso drawable usado como ícone do banco.
 * Use este tipo para escolher a imagem exibida ao lado do nome e saldo.
 */
enum class BankType(val icon: Int) {
  ITAU(R.drawable.itau_unibanco),
  NUBANK(R.drawable.nubank),
  SANTANDER(R.drawable.santander_brasil),
  BB(R.drawable.banco_do_brasil)
}


/**
 * Composable que exibe o nome do banco, o saldo formatado e um botão de ação.
 *
 * Este componente é intencionalmente stateless: recebe todos os valores como
 * parâmetros e notifica eventos através de `onClick`.
 *
 * Parâmetros:
 * @param modifier Modifier opcional para aplicar ao contêiner externo (Row).
 * @param name Nome do banco ou conta a ser exibido.
 * @param value Valor monetário do saldo. Este valor é apresentado por
 *              `CurrencyText`, que formata o float adequadamente.
 * @param bankType Enum [BankType] que determina o ícone mostrado.
 * @param showValues Se `true`, o saldo é mostrado; se `false`, o componente
 *                   `CurrencyText` pode ocultar ou mascarar o valor conforme
 *                   a implementação interna.
 * @param onClick Callback acionado ao tocar no botão de ação (ícone de +).
 *
 * Observações de performance:
 * - Como é stateless, evite recriar lambdas externos sem necessidade para
 *   prevenir recompositions desnecessárias. Passar um `remember` ou um
 *   lambda estável é recomendado quando o `onClick` é criado inline.
 */
@Composable
fun BankBalance(
  modifier: Modifier = Modifier,
  name: String,
  value: Float,
  bankType: BankType,
  showValues: Boolean,
  onClick: () -> Unit
) {
  Row(
    modifier = modifier.fillMaxWidth(),
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.SpaceBetween
  ){
    Row(
      verticalAlignment = Alignment.CenterVertically,
      horizontalArrangement = Arrangement.spacedBy(MangosAppTheme.sizing.sm)
    ) {
      Icon(
        modifier = Modifier
          .size(42.dp)
          .padding(MangosAppTheme.sizing.xs)
          .clip(shape= CircleShape),
        painter= painterResource(bankType.icon),
        contentDescription = null,
        tint= Color.Unspecified
      )
      Column {
        Text(
          text = name,
          style = Typography.headlineMedium,
          color = MaterialTheme.colorScheme.onBackground
        )
        CurrencyText(
          value = value,
          showValues = showValues,
          size = CurrencySize.MEDIUM
        )
      }
  }
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

@PreviewLightDark
@Composable
/**
 * Preview simples do `BankBalance` usando o tema do app.
 * Serve para visualização rápida em Light/Dark no Android Studio.
 */
private fun BankBalancePreview() {
  MangosAppTheme {
    BankBalance(
      value= 3333.33f,
      bankType = BankType.NUBANK,
      name= "Nubank",
      showValues = true,
      onClick = {}
    )
  }
}
package com.unifae.lucas.mangosapp.ui.component

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.unifae.lucas.mangosapp.ui.theme.MangosAppTheme
import com.unifae.lucas.mangosapp.ui.theme.Typography

@Composable
fun BodyCard(modifier: Modifier = Modifier, title: String, content: @Composable () -> Unit) {
  Column(
    modifier=modifier,
    verticalArrangement = Arrangement.spacedBy(MangosAppTheme.sizing.sm)
  ){
    Text(
      modifier = Modifier.padding(start= MangosAppTheme.sizing.md),
      text= title,
      style = Typography.headlineLarge
    )
    Card (
      modifier = Modifier.fillMaxWidth().height(220.dp),
      shape = RoundedCornerShape(15)
    ) {
      content()
    }
  }

}

@Preview (uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun BodyCardPreview() {
  MangosAppTheme {
    BodyCard(
      title= "Despesas por Categoria"
    ) {}
  }
}
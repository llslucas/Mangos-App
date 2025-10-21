package com.unifae.lucas.mangosapp.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cottage
import androidx.compose.material.icons.filled.RequestPage
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.unifae.lucas.mangosapp.R
import com.unifae.lucas.mangosapp.ui.theme.MangosAppTheme
import com.unifae.lucas.mangosapp.ui.theme.Primary

@Composable
fun Footer(modifier: Modifier = Modifier, selected: Int, onClick: (selected: Int) -> Unit) {
  Row(
    modifier = modifier
      .background(color = MaterialTheme.colorScheme.surface)
      .height(MangosAppTheme.sizing.x2l)
      .padding(vertical = MangosAppTheme.sizing.sm, horizontal = MangosAppTheme.sizing.lg)
      .fillMaxWidth(),
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.SpaceBetween,
  ) {
    IconButton(
      modifier = Modifier
        .fillMaxHeight()
        .aspectRatio(1f),
      onClick = {
        onClick(1)
      }
    ) {
      Icon(
        modifier = Modifier.aspectRatio(1f),
        imageVector = Icons.Default.RequestPage,
        contentDescription = null,
        tint = if (selected == 1) Primary else LocalContentColor.current
      )
    }

    IconButton(
      modifier = Modifier
        .fillMaxHeight()
        .aspectRatio(1f),
      onClick = {
        onClick(2)
      }
    ) {
      Icon(
        modifier = Modifier.aspectRatio(1f),
        imageVector = Icons.Default.Cottage,
        contentDescription = null,
        tint = if (selected == 2) Primary else LocalContentColor.current
      )
    }

    IconButton(
      modifier = Modifier
        .fillMaxHeight()
        .aspectRatio(1f),
      onClick = {
        onClick(3)
      }
    ) {
      Icon(
        modifier = Modifier.aspectRatio(1f),
        painter = painterResource(R.drawable.trophy),
        contentDescription = null,
        tint = if (selected == 3) Primary else LocalContentColor.current
      )
    }
  }
}

@PreviewLightDark
@Composable
private fun FooterPreview() {
  MangosAppTheme {
    Footer(
      selected = 2,
      onClick = { selected ->
        print(selected)
      }
    )
  }
}
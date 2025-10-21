package com.unifae.lucas.mangosapp.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.platform.LocalContext

private val LightColorScheme = lightColorScheme(
  primary = Primary,
  secondary = Secondary,
  background = LightBackground,
  surface = LightSurface,
  onPrimary = LightTextSecondary,
  onSecondary = LightTextSecondary,
  onBackground = LightTextPrimary,
  onSurface = LightSurfaceElement,
)

private val DarkColorScheme = darkColorScheme(
  primary = Primary,
  secondary = Secondary,
  background = DarkBackground,
  surface = DarkSurface,
  onPrimary = DarkTextSecondary,
  onSecondary = DarkTextSecondary,
  onBackground = DarkTextPrimary,
  onSurface = DarkSurfaceElement,
)

@Composable
fun MangosAppTheme(
  sizing: Sizing = Sizing(),
  darkTheme: Boolean = isSystemInDarkTheme(),
  dynamicColor: Boolean = false,
  content: @Composable () -> Unit
) {
  val colorScheme = when {
    dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
      val context = LocalContext.current
      if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
    }
    darkTheme -> DarkColorScheme
    else -> LightColorScheme
  }

  MaterialTheme(
    colorScheme = colorScheme,
    typography = Typography,
    content = {
      CompositionLocalProvider(
        LocalSizing provides sizing
      ) {
        content()
      }
    }
  )
}

object MangosAppTheme {
  val sizing: Sizing
    @Composable
    get() = LocalSizing.current
}
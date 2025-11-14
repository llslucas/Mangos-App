package com.unifae.lucas.mangosapp.view.theme

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

/**
 * Esquema de cores para tema claro, definindo cores primárias, secundárias, fundo e superfícies.
 */
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

/**
 * Esquema de cores para tema escuro, definindo cores primárias, secundárias, fundo e superfícies.
 */
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

/**
 * Composable que aplica o tema da aplicação, suportando temas claro/escuro e cores dinâmicas.
 *
 * @param sizing Instância de Sizing para espaçamentos (padrão: nova instância).
 * @param darkTheme Se true, usa tema escuro; se false, usa claro (padrão: baseado no sistema).
 * @param dynamicColor Se true e suportado, usa cores dinâmicas do sistema (padrão: false).
 * @param content Conteúdo composable a ser renderizado dentro do tema.
 *
 * Uso: envolve o app ou telas para aplicar MaterialTheme com customizações.
 */
@Composable
fun MangosAppTheme(
  sizing: Sizing = Sizing(),
  darkTheme: Boolean = isSystemInDarkTheme(),
  dynamicColor: Boolean = false,
  content: @Composable () -> Unit
) {
  // Seleciona esquema de cores: dinâmico se suportado, senão baseado em darkTheme
  val colorScheme = when {
    dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
      val context = LocalContext.current
      if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
    }
    darkTheme -> DarkColorScheme
    else -> LightColorScheme
  }

  // Aplica MaterialTheme com esquema selecionado, tipografia e provedor de sizing
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

/**
 * Objeto acessor para o sizing do tema, permitindo acesso composable aos valores de espaçamento.
 */
object MangosAppTheme {
  val sizing: Sizing
    @Composable
    get() = LocalSizing.current
}
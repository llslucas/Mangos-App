package com.unifae.lucas.mangosapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.unifae.lucas.mangosapp.ui.screen.DashboardScreen
import com.unifae.lucas.mangosapp.ui.theme.MangosAppTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      MangosAppTheme {
        DashboardScreen()
      }
    }
  }
}

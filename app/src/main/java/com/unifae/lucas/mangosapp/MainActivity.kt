package com.unifae.lucas.mangosapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.unifae.lucas.mangosapp.view.screen.CreateBankScreen
import com.unifae.lucas.mangosapp.view.screen.CreateCategoryScreen
import com.unifae.lucas.mangosapp.view.screen.CreateTransactionScreen
import com.unifae.lucas.mangosapp.view.screen.DashboardScreen
import com.unifae.lucas.mangosapp.view.screen.ExtratoScreen
import com.unifae.lucas.mangosapp.view.screen.MetaScreen
import com.unifae.lucas.mangosapp.view.theme.MangosAppTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      MangosAppTheme {
        AppNavigation()
      }
    }
  }
}

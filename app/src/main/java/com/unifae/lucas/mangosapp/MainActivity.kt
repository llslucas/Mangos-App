package com.unifae.lucas.mangosapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.unifae.lucas.mangosapp.ui.component.HeaderCard
import com.unifae.lucas.mangosapp.ui.theme.MangosAppTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      MangosAppTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
          HeaderCard(modifier = Modifier.padding(innerPadding)) {  }
        }
      }
    }
  }
}
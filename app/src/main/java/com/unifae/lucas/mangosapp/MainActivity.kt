package com.unifae.lucas.mangosapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.unifae.lucas.mangosapp.ui.component.Result
import com.unifae.lucas.mangosapp.ui.theme.MangosAppTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      MangosAppTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
          Result(
            modifier = Modifier.padding(innerPadding),
            value = 3333.33f,
            showValues = true
          )
        }
      }
    }
  }
}
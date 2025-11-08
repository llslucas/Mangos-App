package com.unifae.lucas.mangosapp.view.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.unifae.lucas.mangosapp.R

val Roboto = FontFamily(
    Font(R.font.roboto_regular, FontWeight.Normal),
  Font(R.font.roboto_semibold, FontWeight.SemiBold),
  Font(R.font.roboto_bold, FontWeight.Bold)
)

val RobotoCondensed = FontFamily(
  Font(R.font.roboto_condensed_regular, FontWeight.Normal),
  Font(R.font.roboto_condensed_semibold, FontWeight.SemiBold),
  Font(R.font.roboto_condensed_bold, FontWeight.Bold)
)

val Typography = Typography(
  // Headings (Roboto Condensed)
  headlineLarge = TextStyle(
    fontFamily = Roboto,
    fontWeight = FontWeight.Bold,
    fontSize = 24.sp,
    lineHeight = 32.sp
  ),
  headlineMedium = TextStyle(
    fontFamily = Roboto,
    fontWeight = FontWeight.Bold,
    fontSize = 18.sp,
    lineHeight = 24.sp
  ),
  headlineSmall = TextStyle(
    fontFamily = Roboto,
    fontWeight = FontWeight.SemiBold,
    fontSize = 14.sp,
    lineHeight = 18.sp
  ),

  // Subheading
  titleSmall = TextStyle(
    fontFamily = Roboto,
    fontWeight = FontWeight.SemiBold,
    fontSize = 14.sp,
    lineHeight = 16.sp
  ),

  // Numbers
  bodyLarge = TextStyle( // number-md
    fontFamily = Roboto,
    fontWeight = FontWeight.Bold,
    fontSize = 24.sp,
    lineHeight = 32.sp
  ),
  bodyMedium = TextStyle( // number-sm
    fontFamily = Roboto,
    fontWeight = FontWeight.SemiBold,
    fontSize = 16.sp,
    lineHeight = 18.sp
  ),

  // Texts (Roboto)
  displayLarge = TextStyle( // text1
    fontFamily = Roboto,
    fontWeight = FontWeight.Normal,
    fontSize = 32.sp,
    lineHeight = (32.sp * 1.2f) // 120%
  ),
  displayMedium = TextStyle( // text2
    fontFamily = Roboto,
    fontWeight = FontWeight.Normal,
    fontSize = 24.sp,
    lineHeight = (24.sp * 1.2f) // 120%
  )
)
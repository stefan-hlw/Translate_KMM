package com.pepa.translate_kmm.android.core.theme

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color
import com.pepa.translate_kmm.core.presentation.Colors

val AccentViolet = Color(Colors.AccentViolet)
val LightBlue = Color(Colors.LightBlue)
val LightBlueGrey = Color(Colors.LightBlueGrey)
val TextBlack = Color(Colors.TextBlack)
val DarkGrey = Color(Colors.DarkGrey)

val lightColors = lightColorScheme(
    primary = AccentViolet,
    onPrimary = Color.White,
    background = LightBlueGrey,
    onBackground = TextBlack,
    surface = Color.White,
    onSurface = TextBlack
)

val darkColors = darkColorScheme(
    primary = AccentViolet,
    onPrimary = Color.White,
    background = DarkGrey,
    onBackground = Color.White,
    surface = DarkGrey,
    onSurface = Color.White
)
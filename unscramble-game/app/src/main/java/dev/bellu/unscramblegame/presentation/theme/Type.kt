package dev.bellu.unscramblegame.presentation.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontVariation
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import dev.bellu.unscramblegame.R

val Typography = Typography(
    headlineSmall = TextStyle(
        fontSize = 16.sp,
        fontFamily = FontFamily(Font(R.font.mont)),
        fontWeight = FontWeight(600),
        color = Colors.tertiary,

        textAlign = TextAlign.Center,
        letterSpacing = 0.8.sp,
    ),
    headlineMedium = TextStyle(
        fontSize = 24.sp,
        fontFamily = FontFamily(Font(R.font.mont)),
        fontWeight = FontWeight(700),
        color = Colors.onSecondary,
    ),
    headlineLarge = TextStyle(
        fontSize = 36.63.sp,
        fontFamily = FontFamily(Font(R.font.gula)),
        fontWeight = FontWeight(400),
        color = Colors.secondary,
        letterSpacing = 0.73.sp,
    ),
    displaySmall = TextStyle(
        fontSize = 28.sp,
        fontWeight = FontWeight(700),
        fontFamily = FontFamily(Font(R.font.mont)),
        color = Colors.onTertiary,
    ),
    titleSmall = TextStyle(
        fontSize = 16.sp,
        fontFamily = FontFamily(Font(R.font.mont)),
        fontWeight = FontWeight(500),
        color = Colors.onSecondary,
        textAlign = TextAlign.Center,
    ),
    titleMedium = TextStyle(
        fontSize = 34.sp,
        fontFamily = FontFamily(Font(R.font.mont)),
        fontWeight = FontWeight(700),
        color = Colors.tertiary,
        textAlign = TextAlign.Center,
    ),
    labelSmall = TextStyle(
        fontSize = 16.sp,
        fontFamily = FontFamily(Font(R.font.mont)),
        fontWeight = FontWeight(600),
        color = Colors.onQuaternary,
        textAlign = TextAlign.Center,
        letterSpacing = 0.8.sp,
    ),
    labelMedium = TextStyle(
        fontSize = 33.7.sp,
        fontWeight = FontWeight(700),
        fontFamily = FontFamily(Font(R.font.mont)),
        color = Colors.tertiary,
        letterSpacing = 5.1.sp
    ),
    displayMedium = TextStyle(
        fontSize = 42.7.sp,
        fontWeight = FontWeight(400),
        fontFamily = FontFamily(Font(R.font.gula)),
        color = Colors.tertiary,
        letterSpacing = 0.43.sp
    ),
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)
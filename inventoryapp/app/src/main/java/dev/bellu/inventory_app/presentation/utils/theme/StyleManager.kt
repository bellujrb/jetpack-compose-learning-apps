package dev.bellu.inventory_app.presentation.utils.theme

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

object Colors {
    val primary = Color(0xFF1A1A1A)
    val onPrimary = Color(0xFF8859FE)
    val secondary = Color(0xFF393B3F)
    val onSecondary = Color(0xFFFFFFFF)
    val tertiary = Color(0xFF8A929A)
}

object TextManager{
    val titlePurple = TextStyle(
        color = Colors.onPrimary,
        fontSize = 28.sp,
        fontWeight = FontWeight(500)
    )
    val smallWhite = TextStyle(
        color = Colors.onSecondary,
        fontSize = 16.sp,
        fontWeight = FontWeight(500)
    )
    val mediumWhite = TextStyle(
        color = Colors.onSecondary,
        fontSize = 20.sp,
        fontWeight = FontWeight(500)
    )
}
package dev.bellu.dessertrelease.presentation.utils

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

object Colors {
    val primary = Color(0xFF1A1A1A)
    val onPrimary = Color(0xFF8859FE)
    val secondary = Color(0xFF393B3F)
    val onSecondary = Color(0xFFFFFFFF)
}

object TextManager {
    val titleHeader = TextStyle(
        fontSize = 20.sp,
        fontWeight = FontWeight(500),
        color = Colors.onPrimary,
    )
    val mediumWhite = TextStyle(
        fontSize = 20.sp,
        lineHeight = 28.sp,
        fontWeight = FontWeight(500),
        color = Colors.onSecondary
    )
}

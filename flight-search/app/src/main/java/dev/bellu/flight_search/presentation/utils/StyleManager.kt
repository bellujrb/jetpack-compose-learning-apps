package dev.bellu.flight_search.presentation.utils

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

object Colors {
    val primary = Color(0xFF1D1D1F)
    val onPrimary = Color(0xFF313133)
    val secondary = Color(0xFFFFFFFF)
    val onSecondary = Color(0xFFA5A8B0)
}

object TextManager{
    val titleTopAppBar = TextStyle(
        fontSize = 17.sp,
        color = Colors.secondary
    )
    val smallWhite = TextStyle(
        fontSize = 16.sp,
        color = Colors.secondary,
        fontWeight = FontWeight(400)
    )
    val mediumWhite = TextStyle(
        fontSize = 18.sp,
        color = Colors.secondary,
        fontWeight = FontWeight(600)
    )
}
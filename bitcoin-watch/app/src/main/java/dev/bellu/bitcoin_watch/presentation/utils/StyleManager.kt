package dev.bellu.bitcoin_watch.presentation.utils

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

object Colors {
    val primary = Color(0xFFF7931A)
    val onPrimary = Color(0xFFFFFFFF)
    val secondary = Color(0x99000000)
    val onSecondary = Color(0xFF333333)
    val tertiary = Color(0xFF59C88A)
    val onTertiary = Color(0xFFFF0000)
}

object TextManager{
    val superSmallBlack = TextStyle(
        fontSize = 12.sp,
        fontWeight = FontWeight(600),
        color = Colors.onSecondary
    )
    val smallBlack = TextStyle(
        fontSize = 18.sp,
        fontWeight = FontWeight(400),
        color = Colors.onSecondary
    )
    val mediumBoldBlack = TextStyle(
        fontSize = 20.sp,
        fontWeight = FontWeight(700),
        color = Colors.onSecondary
    )
    val bigBlack = TextStyle(
        fontSize = 30.sp,
        fontWeight = FontWeight(600),
        color = Colors.onSecondary
    )
}
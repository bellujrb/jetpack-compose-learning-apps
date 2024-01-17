package dev.bellu.unscramblegame.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.bellu.unscramblegame.presentation.theme.Colors
import dev.bellu.unscramblegame.presentation.theme.Typography

@Composable
fun InputLetter(letter: String, index: Int, onClick: () -> Unit) {
    Box(modifier = Modifier.padding(8.dp)){
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .height(60.dp)
                .width(60.dp)
                .background(color = Colors.secondary, shape = RoundedCornerShape(3.dp))
                .clickable {
                    onClick()
                }
        ) {
            Text(letter, style = Typography.titleMedium)
        }
    }
}
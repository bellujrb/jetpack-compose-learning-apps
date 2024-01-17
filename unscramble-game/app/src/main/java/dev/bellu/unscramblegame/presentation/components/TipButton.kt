package dev.bellu.unscramblegame.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import dev.bellu.unscramblegame.presentation.theme.Colors
import dev.bellu.unscramblegame.presentation.theme.Typography

@Composable
fun TipButton() {
    Box(contentAlignment = Alignment.Center,
        modifier = Modifier
            .padding(24.dp)
            .width(40.9.dp)
            .height(40.9.dp)
            .shadow(
                elevation = 2.9.dp,
                spotColor = Colors.onTertiary,
                ambientColor = Colors.onTertiary
            )
            .background(color = Colors.tertiary, shape = RoundedCornerShape(size = 36.5.dp))
    ){
        Text(
            "?",
            style = Typography.displaySmall,
        )
    }
}

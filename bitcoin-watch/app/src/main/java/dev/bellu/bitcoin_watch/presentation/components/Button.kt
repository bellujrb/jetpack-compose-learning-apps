package dev.bellu.bitcoin_watch.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.bellu.bitcoin_watch.presentation.utils.Colors

@Composable
fun Button(title: String, maxWidth: Float, onClick: () -> Unit){

    val buttonColors: ButtonColors = ButtonDefaults.buttonColors(
        containerColor = Colors.primary
    )
    androidx.compose.material3.Button(
        onClick = onClick,
        colors = buttonColors,
        modifier = Modifier
            .height(44.dp)
            .fillMaxWidth(maxWidth)
    ) {
        Text(text = title)
    }
}

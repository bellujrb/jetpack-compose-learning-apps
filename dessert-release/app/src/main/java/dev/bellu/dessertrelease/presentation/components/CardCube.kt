package dev.bellu.dessertrelease.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.bellu.dessertrelease.presentation.utils.Colors
import dev.bellu.dessertrelease.presentation.utils.TextManager

@Composable
fun CardCube(title: String){
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Colors.secondary
        ),
        modifier = Modifier
            .padding(12.dp)
            .width(169.dp)
            .height(105.dp),
        content = {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                Text(title, style = TextManager.mediumWhite)
            }
        }
    )
}
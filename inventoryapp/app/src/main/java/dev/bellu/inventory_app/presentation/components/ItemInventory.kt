package dev.bellu.inventory_app.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.bellu.inventory_app.data.entity.ItemEntity
import dev.bellu.inventory_app.presentation.utils.theme.Colors
import dev.bellu.inventory_app.presentation.utils.theme.TextManager

@Composable
@Preview
fun ItemInventory(itemModel: ItemEntity, onClick: () -> Unit){
    Box(
        modifier = Modifier
            .fillMaxWidth(0.9f)
            .height(100.dp)
            .background(color = Colors.secondary, shape = RoundedCornerShape(32.dp))
            .clickable { onClick() }
    ){
        Row(verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = Modifier.fillMaxSize()) {
            Column(verticalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxHeight(0.6f)) {
                Text(text = itemModel.name, style = TextManager.mediumWhite)
                Text(text = "${itemModel.stock} in stock", style = TextManager.smallWhite)
            }
            Text("$${itemModel.price}", style = TextManager.mediumWhite)
        }
    }
}
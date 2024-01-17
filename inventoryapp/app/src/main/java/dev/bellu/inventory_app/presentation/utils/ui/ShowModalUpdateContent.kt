package dev.bellu.inventory_app.presentation.utils.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.bellu.inventory_app.presentation.components.Button
import dev.bellu.inventory_app.presentation.components.Input
import dev.bellu.inventory_app.presentation.utils.theme.Colors
import dev.bellu.inventory_app.presentation.utils.theme.TextManager
import dev.bellu.inventory_app.presentation.viewmodels.HomeViewModel
import kotlinx.coroutines.launch

@Composable
fun ShowModalUpdateContent(viewModel: HomeViewModel){

    val scope = rememberCoroutineScope()
    var inputPrice by remember { mutableStateOf("") }
    var inputQuantity by remember { mutableStateOf("") }

    AlertDialog(
        modifier = Modifier.width(200.dp * 5),
        containerColor = Colors.secondary,
        title = {
            Column {
                Input(
                    label = "New price the product",
                    placeholder = "Price",
                    value = inputPrice,
                    onValueChange = {
                        inputPrice = it
                    },
                    maxWidth = 0.95f
                )
                Spacer(modifier = Modifier.height(7.5.dp))
                Input(
                    label = "New quantity the product",
                    placeholder = "Quantity",
                    value = inputQuantity,
                    onValueChange = {
                        inputQuantity = it
                    },
                    maxWidth = 0.95f
                )
                Spacer(modifier = Modifier.height(20.dp))
                Button(
                    title = "Update",
                    maxWidth = 0.95f
                ) {
                    scope.launch {
                        viewModel.updateItem(
                            newPrice = inputPrice.toDouble(),
                            newStock = inputQuantity.toInt()
                        )
                    }
                }
            }
        },
        onDismissRequest = { viewModel.changeStateModal() },
        confirmButton = {
            Text("Cancel",
                style = TextManager.smallWhite,
                modifier = Modifier.clickable { viewModel.cancelAction() })
        },
    )
}
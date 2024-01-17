package dev.bellu.inventory_app.presentation.utils.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.bellu.inventory_app.presentation.components.Button
import dev.bellu.inventory_app.presentation.components.Input
import dev.bellu.inventory_app.presentation.utils.theme.Colors
import dev.bellu.inventory_app.presentation.viewmodels.HomeViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShowBottomSheetContent(viewModel: HomeViewModel, sheetState: SheetState){

    val scope = rememberCoroutineScope()
    var inputName by remember { mutableStateOf("") }
    var inputPrice by remember { mutableStateOf("") }
    var inputQuantity by remember { mutableStateOf("") }

    ModalBottomSheet(
        onDismissRequest = {
            viewModel.changeStatusBottom()
        },
        containerColor = Colors.secondary,
        sheetState = sheetState,
        modifier = Modifier
            .fillMaxHeight(0.45f),
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
        ) {
            Input(
                label = "Your name the product",
                placeholder = "Name",
                value = inputName,
                onValueChange = {
                    inputName = it
                },
                maxWidth = 0.9f
            )
            Spacer(modifier = Modifier.height(7.5.dp))
            Input(
                label = "Your price the product",
                placeholder = "Price",
                value = inputPrice,
                onValueChange = {
                    inputPrice = it
                },
                maxWidth = 0.9f
            )
            Spacer(modifier = Modifier.height(7.5.dp))
            Input(
                label = "Your quantity the product",
                placeholder = "Quantity",
                value = inputQuantity,
                onValueChange = {
                    inputQuantity = it
                },
                maxWidth = 0.9f
            )
            Spacer(modifier = Modifier.height(20.dp))
            Button(
                title = "Add",
                maxWidth = 0.9f
            ) {
                scope.launch {
                    viewModel.addItem(
                        name = inputName,
                        price = inputPrice,
                        stock = inputQuantity
                    )
                }
            }
        }
    }
}
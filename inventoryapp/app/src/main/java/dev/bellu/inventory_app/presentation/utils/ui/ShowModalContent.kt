package dev.bellu.inventory_app.presentation.utils.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.bellu.inventory_app.presentation.components.Button
import dev.bellu.inventory_app.presentation.viewmodels.HomeViewModel
import kotlinx.coroutines.launch

@Composable
fun ShowModalContent(viewModel: HomeViewModel){

    val uiState = viewModel.uiState.collectAsState()
    val scope = rememberCoroutineScope()

    AlertDialog(
        title = {
            Column {
                Button(
                    title = "Update",
                    maxWidth = 0.9f
                ) {
                    viewModel.changeStateModalUpdate()
                }
                Spacer(modifier = Modifier.height(10.dp))
                Button(
                    title = "Delete",
                    maxWidth = 0.9f,
                    onClick = {
                        scope.launch {
                            viewModel.removeItem(uiState.value.actualItem)
                        }
                    }
                )
                Spacer(modifier = Modifier.height(10.dp))
            }
        },
        onDismissRequest = { viewModel.changeStateModal() },
        confirmButton = {
            Text("Return",
                modifier = Modifier.clickable { viewModel.changeStateModal() })
        },
    )
}
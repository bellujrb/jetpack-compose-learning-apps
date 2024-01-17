package dev.bellu.inventory_app.presentation.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import dev.bellu.inventory_app.data.database.InventoryDatabase
import dev.bellu.inventory_app.data.entity.ItemEntity
import dev.bellu.inventory_app.presentation.components.Input
import dev.bellu.inventory_app.presentation.components.ItemInventory
import dev.bellu.inventory_app.presentation.utils.theme.Colors
import dev.bellu.inventory_app.presentation.utils.theme.TextManager
import dev.bellu.inventory_app.presentation.utils.ui.ShowBottomSheetContent
import dev.bellu.inventory_app.presentation.utils.ui.ShowModalContent
import dev.bellu.inventory_app.presentation.utils.ui.ShowModalUpdateContent
import dev.bellu.inventory_app.presentation.viewmodels.HomeViewModel
import kotlinx.coroutines.launch

@SuppressLint("StateFlowValueCalledInComposition")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView(
    viewModel: HomeViewModel = HomeViewModel(
        db = InventoryDatabase.getDatabase(LocalContext.current)
    )
) {
    val uiState = viewModel.uiState.collectAsState()
    val sheetState = rememberModalBottomSheetState()


    LaunchedEffect(key1 = null) {
        viewModel.fetchDataFromDatabase()
    }

    Scaffold(floatingActionButton = {
        FloatingActionButton(onClick = {
            viewModel.changeStatusBottom()
        }, content = {
            Icon(imageVector = Icons.Default.Add, contentDescription = "Add")
        }, containerColor = Colors.onPrimary
        )
    }, topBar = {
        TopAppBar(
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Colors.primary, titleContentColor = Colors.primary
            ),
            title = {
                Box(
                    contentAlignment = Alignment.Center, modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "Inventory", style = TextManager.titlePurple)
                }
            },
        )
    }) { innerPadding ->
        uiState.value.isShowModal.run {
            if (this) ShowModalContent(viewModel = viewModel)
        }
        uiState.value.isShowModalUpdate.run {
            if (this) ShowModalUpdateContent(viewModel = viewModel)
        }
        uiState.value.isBottomSheetVisible.run {
            if (this) ShowBottomSheetContent(
                viewModel = viewModel,
                sheetState = sheetState,
            )
        }
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(color = Colors.primary)
        ) {
            items(uiState.value.itemList.size) { index ->
                val item = uiState.value.itemList[index]
                Box(modifier = Modifier.padding(4.dp)) {
                    ItemInventory(itemModel = ItemEntity(
                        name = item.name,
                        price = item.price,
                        stock = item.stock,
                    ), onClick = {
                        viewModel.changeActualItem(item)
                    })
                }
            }
        }
    }
}
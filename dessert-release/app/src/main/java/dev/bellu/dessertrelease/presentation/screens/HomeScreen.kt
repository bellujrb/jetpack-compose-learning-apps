package dev.bellu.dessertrelease.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.bellu.dessertrelease.data.LocalDessertReleaseData
import dev.bellu.dessertrelease.presentation.components.CardCube
import dev.bellu.dessertrelease.presentation.components.CardRectangle
import dev.bellu.dessertrelease.presentation.utils.Colors
import dev.bellu.dessertrelease.presentation.utils.TextManager
import dev.bellu.dessertrelease.presentation.viewmodels.HomeViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(viewModel: HomeViewModel = HomeViewModel()) {

    val uiState = viewModel.uiState.collectAsState()
    val versions = LocalDessertReleaseData.dessertReleases

    Scaffold(
        containerColor = Colors.primary,
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Colors.primary
                ),
                title = {
                    Text(text = "Dessert Release", style = TextManager.titleHeader)
                },
                actions = {
                    IconButton(onClick = { viewModel.changeView() }) {
                        Icon(
                            imageVector = Icons.Default.Menu,
                            contentDescription = null
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (uiState.value.isVertical) {
                LazyColumn {
                    items(versions.size) { index ->
                        CardRectangle(title = versions[index])
                    }
                }
            } else {
                LazyVerticalGrid(
                    columns = GridCells.Adaptive(minSize = 128.dp),
                ){
                    items(versions.size) {index ->
                        CardCube(title = versions[index])
                    }
                }
            }
        }
    }
}
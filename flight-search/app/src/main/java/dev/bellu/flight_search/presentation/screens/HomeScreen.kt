package dev.bellu.flight_search.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import dev.bellu.flight_search.presentation.components.InputSearch
import dev.bellu.flight_search.presentation.utils.Colors
import dev.bellu.flight_search.presentation.utils.TextManager
import dev.bellu.flight_search.R
import dev.bellu.flight_search.data.database.FlightDatabase
import dev.bellu.flight_search.presentation.components.Instructions
import dev.bellu.flight_search.presentation.viewmodel.HomeViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(viewModel: HomeViewModel = HomeViewModel(
    db = FlightDatabase.getDatabase(context = LocalContext.current)
)
){

    val scope = rememberCoroutineScope()
    var inputSearch by remember { mutableStateOf("") }

    LaunchedEffect(key1 = null){
        scope.launch {
            viewModel.fetchDataFromDatabase()
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Colors.onPrimary
                ),
                title = {
                    Text(stringResource(id = R.string.title), style = TextManager.titleTopAppBar)
                }
            )
        },
        content = { innerPadding ->
            Column(modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(color = Colors.primary)
            ) {
                InputSearch(
                    label = stringResource(id = R.string.input_title),
                    placeholder = stringResource(id = R.string.input_placeholder),
                    inputSearch = inputSearch,
                    onValueChange = {}
                )
                if(inputSearch.isEmpty()){
                    Instructions()
                }
            }
        }
    )
}
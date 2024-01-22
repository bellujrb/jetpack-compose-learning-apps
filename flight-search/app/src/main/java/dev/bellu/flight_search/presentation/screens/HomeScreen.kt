package dev.bellu.flight_search.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import dev.bellu.flight_search.presentation.components.InputSearch
import dev.bellu.flight_search.presentation.utils.Colors
import dev.bellu.flight_search.presentation.utils.TextManager
import dev.bellu.flight_search.R
import dev.bellu.flight_search.data.database.FlightDatabase
import dev.bellu.flight_search.presentation.components.FlightComponent
import dev.bellu.flight_search.presentation.components.Instructions
import dev.bellu.flight_search.presentation.entity.FlightEntity
import dev.bellu.flight_search.presentation.viewmodel.HomeViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    viewModel: HomeViewModel = HomeViewModel(
        db = FlightDatabase.getDatabase(context = LocalContext.current)
    ),
) {
    val uiState: State<HomeUiState> = viewModel.uiState.collectAsState()
    var inputSearch by remember { mutableStateOf("") }

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
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
                    .background(color = Colors.primary)
            ) {
                InputSearch(
                    label = stringResource(id = R.string.input_title),
                    placeholder = stringResource(id = R.string.input_placeholder),
                    inputSearch = inputSearch,
                    onValueChange = {
                        inputSearch = it
                    }
                )
                if (inputSearch.isEmpty()) {
                    Instructions()
                } else {
                    LazyColumn(
                        content = {
                            val flights = uiState.value.flights
                            val filteredFlights = if (inputSearch.isEmpty()) {
                                flights
                            } else {
                                flights.filter { flight ->
                                    flight.departCode.contains(inputSearch, ignoreCase = true) ||
                                            flight.arriveCode.contains(inputSearch, ignoreCase = true)
                                }
                            }

                            items(filteredFlights.size) { index ->
                                FlightComponent(flights = FlightEntity(
                                    departName = filteredFlights[index].departName,
                                    departCode = filteredFlights[index].departCode,
                                    arriveName = filteredFlights[index].arriveName,
                                    arriveCode = filteredFlights[index].arriveCode
                                ))
                            }
                        }
                    )
                }
            }
        }
    )
}
package dev.bellu.bitcoin_watch.presentation.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import dev.bellu.bitcoin_watch.presentation.utils.Colors
import dev.bellu.bitcoin_watch.presentation.utils.TextManager
import dev.bellu.bitcoin_watch.R
import dev.bellu.bitcoin_watch.presentation.components.Input
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(viewModel: HomeViewModel = HomeViewModel()) {

    val uiState by viewModel.uiState.collectAsState()
    val sheetState = rememberModalBottomSheetState()
    //val scope = rememberCoroutineScope()

    LaunchedEffect(key1 = null){
        viewModel.getBitcoinBRL()
    }

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Colors.onPrimary)
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Box(
                                contentAlignment = Alignment.Center,
                                modifier = Modifier
                                    .height(40.dp)
                                    .width(40.dp)
                                    .background(color = Colors.primary, shape = RoundedCornerShape(100.dp))
                            ) {
                                Text("B")
                            }
                            Spacer(modifier = Modifier.width(10.dp))
                            Column(verticalArrangement = Arrangement.SpaceAround) {
                                Text("Bem vindo", style = TextManager.superSmallBlack)
                                Text("Belluzzo", style = TextManager.smallBlack)
                            }
                        }
                    },
                    actions = {
                        Icon(
                            imageVector = Icons.Default.ExitToApp,
                            contentDescription = "Exit"
                        )
                    }
                )
            }
        ) { innerPadding ->
            if(viewModel.isModalVisible.value){
                ModalBottomSheet(
                    onDismissRequest = { /*TODO*/ },
                    sheetState = sheetState,
                    modifier = Modifier
                        .fillMaxHeight(0.3f)
                ) {
                    Box(contentAlignment = Alignment.Center,
                        modifier = Modifier.fillMaxSize()){
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text("Calculator Bitcoin", style = TextManager.mediumBoldBlack)
                            Text("Bitcoin Result", style = TextManager.smallBlack)
                            Text("${uiState.bitcoinCurrentConvert}", style = TextManager.bigBlack)
                        }
                    }
                }
            }
            Column(modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Bitcoin Value in 24H", style = TextManager.smallBlack)
                    Text("R$ ${uiState.bitcoinValue}", style = TextManager.bigBlack)
                    Row {
                        Text("R$ ${uiState.bitcoinAppreciationValue} ")
                        Text("+${uiState.bitcoinAppreciationPercentage}%")
                    }
                }
                Spacer(modifier = Modifier.height(20.dp))
                Box(modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .align(Alignment.CenterHorizontally)){
                    Image(painter = painterResource(id = R.drawable.mock), contentDescription = "Mock")
                }
                Spacer(modifier = Modifier.height(20.dp))
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("Calculator Bitcoin")
                    Row {
                        Input(
                            label = "BRL",
                            placeholder = "BRL",
                            value = "BRL",
                            onValueChange = {},
                            maxWidth = 0.2f
                        )
                        Spacer(modifier = Modifier.width(20.dp))
                        Input(
                            label = "Price",
                            placeholder = "Price",
                            value = uiState.priceInput.toString(),
                            onValueChange = {},
                            maxWidth = 0.95f
                        )
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    dev.bellu.bitcoin_watch.presentation.components.Button(
                        title = "Consult",
                        maxWidth = 0.97f,
                        onClick = {
                            viewModel.consultBitcoinBRL(uiState.priceInput)
                        }
                    )
                }
            }
        }
    }
}
package dev.bellu.unscramblegame.presentation.screens.home

import BigButton
import InputWord
import MiniButton
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import dev.bellu.unscramblegame.R
import dev.bellu.unscramblegame.data.allWords
import dev.bellu.unscramblegame.presentation.components.InputLetter
import dev.bellu.unscramblegame.presentation.components.ScrambledWordView
import dev.bellu.unscramblegame.presentation.theme.Colors
import dev.bellu.unscramblegame.presentation.theme.Typography
import dev.bellu.unscramblegame.presentation.theme.UnscrambleGameTheme

@Composable
fun HomeScreen(viewModel: HomeViewModel = viewModel()) {

    val uiState by viewModel.uiState.collectAsState()
    val listLetters = viewModel.listLetters

    var inputWord by remember { mutableStateOf("") }

    UnscrambleGameTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Colors.primary)
        ) {
            Column {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .fillMaxHeight(0.2f)
                        .fillMaxWidth()
                ) {
                    Text(
                        text = stringResource(R.string.app_name),
                        style = Typography.displayMedium
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            color = Colors.tertiary, shape = RoundedCornerShape(
                                topEnd = 50.dp, topStart = 50.dp
                            )
                        )
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Spacer(
                            modifier = Modifier.height(12.dp)
                        )
                        ScrambledWordView(scrambled = uiState.scrambled)
                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier.padding(24.dp)
                        ) {
                            Text(
                                stringResource(R.string.app_caption),
                                style = Typography.titleSmall,
                            )
                        }
                        InputWord(
                            label = "",
                            value = inputWord,
                            onValueChange = {
                                inputWord = it
                            }
                        )
                        Spacer(
                            modifier = Modifier.height(12.dp)
                        )
                        LazyColumn {
                            item {
                                LazyRow {
                                    items(minOf(listLetters.size, 5)) { index ->
                                        InputLetter(
                                            listLetters[index],
                                            index = index,
                                            onClick = {
                                                inputWord += listLetters[index]
                                            }
                                        )
                                    }
                                }
                            }
                            item {
                                LazyRow {
                                    items((listLetters.size - 5).coerceAtLeast(0)) { index ->
                                        InputLetter(
                                            listLetters[index + 5],
                                            index = index,
                                            onClick = {
                                                inputWord += listLetters[index + 5]
                                            }
                                        )
                                    }
                                }
                            }
                        }
                        Spacer(
                            modifier = Modifier.height(20.dp)
                        )
                        Row {
                            MiniButton(
                                title = "CLEAR",
                                onClick = { inputWord = "" }
                            )
                            Spacer(
                                modifier = Modifier.width(20.dp)
                            )
                            MiniButton(
                                title = "SKIP",
                                onClick = {
                                    viewModel.skipRound()
                                }
                            )
                        }
                        Spacer(
                            modifier = Modifier.height(20.dp)
                        )
                        BigButton(
                            title = "SUBMIT",
                            onClick = {
                                viewModel.playGame(inputWord)
                                inputWord = ""
                            }
                        )
                        Spacer(modifier = Modifier.height(20.dp))
                        Text(text = "Score: ${uiState.score}", style = Typography.headlineMedium )
                    }
                }
            }
        }
    }
}


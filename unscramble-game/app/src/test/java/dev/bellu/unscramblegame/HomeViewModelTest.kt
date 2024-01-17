package dev.bellu.unscramblegame

import dev.bellu.unscramblegame.presentation.screens.home.HomeViewModel
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Before
import org.junit.Test

class HomeViewModelTest {
    private lateinit var viewModel: HomeViewModel

    @Before
    fun setUp(){
        viewModel = HomeViewModel()
    }

    @Test
    fun playGame_correctInput_updateScoreAndChangesWord(){
        val initialScore = viewModel.uiState.value.score
        val initialWord = viewModel.uiState.value.word

        viewModel.playGame(initialWord)

        val expectedScore = initialScore + 10
        val newWord = viewModel.uiState.value.word

        assertEquals(expectedScore, viewModel.uiState.value.score)
        assertNotEquals(initialWord, newWord)
    }

}
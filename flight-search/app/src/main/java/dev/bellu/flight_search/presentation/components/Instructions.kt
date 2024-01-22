package dev.bellu.flight_search.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import dev.bellu.flight_search.presentation.utils.TextManager
import dev.bellu.flight_search.R

@Composable
fun Instructions() {

    val airports = listOf(
        Pair(R.string.code_svo, R.string.name_svo),
        Pair(R.string.code_muc, R.string.name_muc),
        Pair(R.string.code_dus, R.string.name_dus),
        Pair(R.string.code_ath, R.string.name_ath),
        Pair(R.string.code_lys, R.string.name_lys),
        Pair(R.string.code_fco, R.string.name_fco),
        Pair(R.string.code_vie, R.string.name_vie),
        Pair(R.string.code_kef, R.string.name_kef)
    )
    Column {
        airports.forEach { (codeRes, nameRes) ->
            InstructionsComponent(
                title = stringResource(id = codeRes),
                subtitle = stringResource(id = nameRes)
            )
        }
    }
}

@Composable
fun InstructionsComponent(title: String, subtitle: String) {
    Column(modifier = Modifier.padding(8.dp)) {
        Text(title, style = TextManager.mediumWhite)
        Text(subtitle, style = TextManager.smallWhite)
    }
}
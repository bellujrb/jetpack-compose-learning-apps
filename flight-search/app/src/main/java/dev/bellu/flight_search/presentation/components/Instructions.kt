package dev.bellu.flight_search.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import dev.bellu.flight_search.presentation.utils.TextManager
import dev.bellu.flight_search.R

@Composable
fun Instructions(){
    Column {
        InstructionsComponent(
            title = stringResource(id = R.string.code_svo),
            subtitle = stringResource(id = R.string.name_svo)
        )
        InstructionsComponent(
            title = stringResource(id = R.string.code_muc),
            subtitle = stringResource(id = R.string.name_muc)
        )
    }
}

@Composable
fun InstructionsComponent(title: String, subtitle: String){
    Column {
        Text(title, style = TextManager.mediumWhite)
        Text(subtitle, style = TextManager.smallWhite)
    }
}
package dev.bellu.flight_search.presentation.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.bellu.flight_search.presentation.utils.Colors

@Composable
fun InputSearch(label: String, placeholder: String) {
    var inputSearch by remember { mutableStateOf("") }

    OutlinedTextField(
        label = {
            Text(label)
        },
        placeholder = {
            Text(placeholder)
        },
        value = inputSearch,
        onValueChange = {
            inputSearch = it
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null
            )
        },
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Colors.onPrimary,
            unfocusedContainerColor = Colors.onPrimary,
            focusedIndicatorColor = Colors.secondary,
            unfocusedIndicatorColor = Colors.secondary,
            focusedLabelColor = Colors.secondary,
            unfocusedLabelColor = Colors.secondary,
            focusedTextColor = Colors.secondary,
            unfocusedTextColor = Colors.secondary,
            focusedLeadingIconColor = Colors.secondary
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    )

}
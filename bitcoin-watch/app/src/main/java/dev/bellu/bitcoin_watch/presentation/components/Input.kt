package dev.bellu.bitcoin_watch.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import dev.bellu.bitcoin_watch.presentation.utils.Colors

@Composable
fun Input(
    label: String,
    placeholder: String,
    value: String,
    onValueChange: (String) -> Unit,
    maxWidth: Float
) {

    val fieldColors: TextFieldColors = TextFieldDefaults.colors(
        focusedContainerColor = Colors.onPrimary,
        unfocusedContainerColor = Colors.onPrimary,
        focusedIndicatorColor = Colors.primary,
        unfocusedIndicatorColor = Colors.primary,
        focusedLabelColor = Colors.onSecondary,
    )

    OutlinedTextField(
        label = {
            Text(label)
        },
        placeholder = {
            Text(placeholder)
        },
        value = value,
        onValueChange = { newValue ->
            onValueChange(newValue)
        },
        visualTransformation = VisualTransformation.None,
        colors = fieldColors,
        shape = RoundedCornerShape(4),
        modifier = Modifier
            .fillMaxWidth(maxWidth)
            .height(60.dp)
    )
}
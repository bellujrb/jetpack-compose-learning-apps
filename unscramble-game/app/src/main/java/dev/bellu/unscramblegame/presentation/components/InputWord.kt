import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import dev.bellu.unscramblegame.presentation.theme.Colors

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun InputWord(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
) {
    val keyboardController = LocalSoftwareKeyboardController.current

    val colorsTextField = TextFieldDefaults.textFieldColors(
        focusedTextColor = Colors.onSecondary
    )
    val keyOptions = KeyboardOptions.Default.copy(
        imeAction = ImeAction.None,
        keyboardType = KeyboardType.Text
    )
    val keyActions = KeyboardActions(
        onDone = {
            keyboardController?.hide()
        }
    )

    TextField(
        value = value,
        onValueChange = { newText -> onValueChange(newText) },
        label = { Text(label) },
        colors = colorsTextField,
        keyboardOptions = keyOptions,
        keyboardActions = keyActions,
    )
}
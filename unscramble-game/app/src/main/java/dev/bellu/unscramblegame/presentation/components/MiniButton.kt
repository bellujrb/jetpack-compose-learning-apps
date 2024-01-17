import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import dev.bellu.unscramblegame.presentation.theme.Colors
import dev.bellu.unscramblegame.presentation.theme.Typography

@Composable
fun MiniButton(title: String, onClick: () -> Unit){
    Box(contentAlignment = Alignment.Center,
        modifier = Modifier
        .background(
            color = Colors.quaternary,
            shape = RoundedCornerShape(size = 42.dp))
        .width(115.dp)
        .height(50.dp)
        .clickable { onClick() }
    ){
        Text(title, style = Typography.labelSmall)
    }
}
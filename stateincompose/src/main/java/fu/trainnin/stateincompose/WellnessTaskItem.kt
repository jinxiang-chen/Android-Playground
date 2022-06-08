package fu.trainnin.stateincompose

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun WellnessTaskItem(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    text: String
) {
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        Text(
            text = text, modifier = Modifier.weight(1f).padding(start = 16.dp)
        )
        IconButton(onClick = onClick) {
            Icon(Icons.Filled.Close, contentDescription = null)
        }
    }
}

@Preview
@Composable
fun WellnessTaskItemPreview() {
    WellnessScreen()
}
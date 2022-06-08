package fu.trainnin.stateincompose

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import fu.trainnin.stateincompose.ui.theme.AndroidPlaygroundTheme

@Composable
fun WellnessScreen(modifier: Modifier = Modifier) {
    WaterCounter(modifier = modifier)
}

@Preview
@Composable
fun WellnessScreenPreview() {
    AndroidPlaygroundTheme {
        WellnessScreen()
    }
}
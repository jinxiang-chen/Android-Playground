package fu.trainnin.stateincompose

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import fu.trainnin.stateincompose.ui.theme.AndroidPlaygroundTheme

@Composable
fun WellnessScreen(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        StatefulCounter()
        WellnessTasksList()
    }
}

@Preview
@Composable
fun WellnessScreenPreview() {
    AndroidPlaygroundTheme {
        WellnessScreen()
    }
}
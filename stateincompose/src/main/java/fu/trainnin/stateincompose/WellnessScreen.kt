package fu.trainnin.stateincompose

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import fu.trainnin.stateincompose.ui.theme.AndroidPlaygroundTheme

@Composable
fun WellnessScreen(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        StatefulCounter()
        val list = remember { getWellnessTasks().toMutableStateList() }
        WellnessTasksList(list = list, onCloseTask = { task -> list.remove(task) })
    }
}

fun getWellnessTasks() = List(30) { i -> WellnessTask(i, "Task # $i") }

@Preview
@Composable
fun WellnessScreenPreview() {
    AndroidPlaygroundTheme {
        WellnessScreen()
    }
}
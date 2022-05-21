package fu.android_playground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import fu.android_playground.ui.theme.ComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background,
                ) {
                    Content()
                }
            }
        }
    }
}

@Composable
fun Content() {
    ConstraintLayoutContent()
}

@Composable
fun ConstraintLayoutContent() {
    ConstraintLayout(
        Modifier.fillMaxSize()
    ) {
        val (text1, text2) = createRefs()
        Text(
            text = "text1",
            modifier = Modifier.constrainAs(text1) {
                start.linkTo(parent.start)
                top.linkTo(parent.top)
                end.linkTo(parent.end)
            }
        )
        Text(
            text = "text2",
            modifier = Modifier.constrainAs(text2) {
                start.linkTo(parent.start)
                top.linkTo(text1.bottom, margin = 16.dp)
                end.linkTo(parent.end)
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeTheme {
        Content()
    }
}
package fu.android_playground.view.box

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import fu.android_playground.ui.theme.ComposeTheme

class BoxActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTheme {
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
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row {
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(Color.Black),
                contentAlignment = Alignment.TopStart
            ) {
                Text(text = "text1", color = Color.White)
            }
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(Color.White),
                contentAlignment = Alignment.TopCenter
            ) {
                Text(text = "text2", color = Color.Black)
            }
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(Color.Black),
                contentAlignment = Alignment.TopEnd
            ) {
                Text(text = "text3", color = Color.White)
            }
        }
        Row {
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(Color.White),
                contentAlignment = Alignment.CenterStart
            ) {
                Text(text = "text4", color = Color.Black)
            }
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(Color.Black),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "text5", color = Color.White)
            }
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(Color.White),
                contentAlignment = Alignment.CenterEnd
            ) {
                Text(text = "text6", color = Color.Black)
            }
        }
        Row {
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(Color.Black),
                contentAlignment = Alignment.BottomStart
            ) {
                Text(text = "text7", color = Color.White)
            }
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(Color.White),
                contentAlignment = Alignment.BottomCenter
            ) {
                Text(text = "text8", color = Color.Black)
            }
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(Color.Black),
                contentAlignment = Alignment.BottomEnd
            ) {
                Text(text = "text9", color = Color.White)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeTheme {
        Content()
    }
}
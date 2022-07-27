package fu.android_playground.view.main

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import fu.android_playground.ui.theme.ComposeTheme
import fu.android_playground.view.column.ColumnActivity
import fu.android_playground.view.constraintlayout.ConstraintLayoutActivity
import fu.android_playground.view.login.LoginActivity
import fu.android_playground.view.row.RowActivity

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
    val context = LocalContext.current
    Column {
        Button(onClick = {
            val intent = Intent(context, ColumnActivity::class.java)
            context.startActivity(intent)
        }) {
            Text(text = "展示Column")
        }
        Button(onClick = {
            val intent = Intent(context, RowActivity::class.java)
            context.startActivity(intent)
        }) {
            Text(text = "展示Row")
        }
        Button(onClick = {
            val intent = Intent(context, ConstraintLayoutActivity::class.java)
            context.startActivity(intent)
        }) {
            Text(text = "展示ConstraintLayout")
        }
        Button(onClick = {
            val intent = Intent(context, LoginActivity::class.java)
            context.startActivity(intent)
        }) {
            Text(text = "登入")
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
package fu.android_playground.view.login

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import fu.android_playground.R
import fu.android_playground.ui.theme.ComposeTheme

class LoginActivity : ComponentActivity() {
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
    ConstraintLayout(
        Modifier.fillMaxSize()
    ) {
        val resources = LocalContext.current.resources
        val guidelineTop = createGuidelineFromTop(0.2f)
        val guidelineLogo = createGuidelineFromTop(0.064f)
        val guidelineStart = createGuidelineFromStart(0.064f)
        val guidelineEnd = createGuidelineFromStart(0.936f)
        val (logo, logoTitle, loginSpacer, logoSubTitle) = createRefs()
        val (accountSpacer, accountBox) = createRefs()
        val (pwdSpacer, pwdBox) = createRefs()
        val (forgotPwdSpacer, forgotPwdBox) = createRefs()
        val (loginButtonSpacer, loginButton) = createRefs()
        val (fbLoginButtonSpacer, fbLoginButton) = createRefs()
        val (otherLoginRow, otherLoginButton) = createRefs()
        
        val accountText = remember { mutableStateOf("") }
        val pwdText = remember { mutableStateOf("") }
        val rememberPwdSwitch = remember { mutableStateOf(false) }
        
        Image(
            modifier = Modifier
                .wrapContentWidth()
                .wrapContentHeight()
                .constrainAs(logo) {
                    top.linkTo(guidelineLogo)
                    end.linkTo(guidelineEnd)
                },
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            colorFilter = ColorFilter.tint(
                Color.Green
            ),
            contentDescription = null
        )
        Text(
            modifier = Modifier
                .wrapContentHeight()
                .wrapContentWidth()
                .constrainAs(logoTitle) {
                    top.linkTo(guidelineTop)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            text = stringResource(id = R.string.stock).uppercase(),
            fontSize = 34.sp,
            letterSpacing = 8.sp,
        )
        Spacer(modifier = Modifier
            .fillMaxHeight(0.002f)
            .fillMaxWidth()
            .constrainAs(loginSpacer) {
                top.linkTo(logoTitle.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            })
        Text(
            modifier = Modifier
                .wrapContentHeight()
                .wrapContentWidth()
                .constrainAs(logoSubTitle) {
                    top.linkTo(loginSpacer.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            text = stringResource(id = R.string.stock_sample).uppercase(),
            fontSize = 54.sp,
            letterSpacing = 4.sp,
        )
        Spacer(modifier = Modifier
            .fillMaxHeight(0.05f)
            .constrainAs(accountSpacer) {
                top.linkTo(logoSubTitle.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            })
        Box(
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth(0.872f)
                .border(
                    1.dp,
                    Color(R.color.color_7d7d7d),
                    RoundedCornerShape(8.dp, 8.dp, 8.dp, 8.dp)
                )
                .padding(8.dp)
                .constrainAs(accountBox) {
                    top.linkTo(accountSpacer.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.icon_login_person),
                    contentDescription = null,
                    colorFilter = ColorFilter.tint(
                        colorResource(R.color.color_7d7d7d)
                    ),
                )
                Spacer(modifier = Modifier.width(8.dp))
                BasicTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight(),
                    value = accountText.value,
                    onValueChange = {
                        accountText.value = it
                    }
                )
            }
        }
        Spacer(modifier = Modifier
            .fillMaxHeight(0.05f)
            .fillMaxWidth()
            .constrainAs(pwdSpacer) {
                top.linkTo(accountBox.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            })
        Box(
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth(0.872f)
                .border(
                    1.dp,
                    Color(R.color.color_7d7d7d),
                    RoundedCornerShape(8.dp, 8.dp, 8.dp, 8.dp)
                )
                .padding(8.dp)
                .constrainAs(pwdBox) {
                    top.linkTo(pwdSpacer.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.icon_login_key),
                    contentDescription = null,
                    colorFilter = ColorFilter.tint(
                        colorResource(R.color.color_7d7d7d)
                    ),
                )
                Spacer(modifier = Modifier.width(8.dp))
                BasicTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight(),
                    value = pwdText.value,
                    onValueChange = {
                        pwdText.value = it
                    }
                )
            }
        }
        Spacer(modifier = Modifier
            .fillMaxHeight(0.054f)
            .fillMaxWidth()
            .constrainAs(forgotPwdSpacer) {
                top.linkTo(pwdBox.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            })
        Row(
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth(0.872f)
                .constrainAs(forgotPwdBox) {
                    top.linkTo(forgotPwdSpacer.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "忘記密碼", color = Color.Black)
            Row(
                Modifier.height(50.dp),
            ) {
                Text(text = "記住密碼", color = Color.Black)
                Switch(
                    checked = rememberPwdSwitch.value, onCheckedChange = {
                        rememberPwdSwitch.value = it
                    })
            }
        }
        Spacer(modifier = Modifier
            .fillMaxHeight(0.04f)
            .fillMaxWidth()
            .constrainAs(loginButtonSpacer) {
                top.linkTo(forgotPwdBox.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            })
        Button(modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth(0.872f)
            .constrainAs(loginButton) {
                top.linkTo(loginButtonSpacer.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            },
            colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(R.color.color_e37326)),
            onClick = {
            }
        ) {
            Text(text = "登入", color = Color.White, fontSize = 20.sp)
        }
        Spacer(modifier = Modifier
            .fillMaxHeight(0.02f)
            .fillMaxWidth()
            .constrainAs(fbLoginButtonSpacer) {
                top.linkTo(loginButton.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            })
        Button(modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth(0.872f)
            .constrainAs(fbLoginButton) {
                top.linkTo(fbLoginButtonSpacer.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            },
            colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(R.color.color_4963b3)),
            onClick = {
            }
        ) {
            Text(text = "FB登入", color = Color.White, fontSize = 20.sp)
        }
        Row(
            modifier = Modifier
                .fillMaxHeight(0.07f)
                .fillMaxWidth(0.872f)
                .constrainAs(otherLoginRow) {
                    top.linkTo(fbLoginButton.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            verticalAlignment = Alignment.CenterVertically
        ) {
            Spacer(
                modifier = Modifier
                    .weight(1f)
                    .height(1.dp)
                    .padding(end = 20.dp)
                    .background(color = colorResource(R.color.color_7d7d7d))
            )
            Text(text = "或", fontSize = 14.sp)
            Spacer(
                modifier = Modifier
                    .weight(1f)
                    .height(1.dp)
                    .padding(start = 20.dp)
                    .background(color = colorResource(R.color.color_7d7d7d))
            )
        }
    
        Button(modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth(0.872f)
            .constrainAs(otherLoginButton) {
                top.linkTo(otherLoginRow.bottom)
                start.linkTo(guidelineStart)
                end.linkTo(guidelineEnd)
                bottom.linkTo(parent.bottom)
            },
            colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(R.color.color_3b9adf)),
            onClick = {
            }
        ) {
            Text(text = "其他方式登入", color = Color.White, fontSize = 20.sp)
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
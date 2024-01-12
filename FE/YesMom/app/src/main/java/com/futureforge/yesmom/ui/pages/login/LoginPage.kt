package com.futureforge.yesmom.ui.pages.login

import android.content.Context
import android.widget.Space
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.futureforge.yesmom.R
import com.futureforge.yesmom.common.UiState
import com.futureforge.yesmom.navigation.Screen
import com.futureforge.yesmom.ui.factory.ViewModelFactory
import com.futureforge.yesmom.ui.theme.YesMomTheme

@Composable
fun LoginPage(
    modifier: Modifier = Modifier,
    context: Context,
    loginViewModel: LoginViewModel =
        viewModel(factory = ViewModelFactory.getInstance(context)),
    navController: NavHostController
) {
    loginViewModel.isLogin.collectAsState(
        initial = UiState.Loading
    ).value.let { uiState ->
        when (uiState) {
            is UiState.Loading -> {
                loginViewModel.getIsAuthLogin()
            }

            is UiState.Success -> {
                LaunchedEffect(key1 = "success") {
                    if (uiState.data) {
                        navController.navigate(Screen.Home.route)
                    }
                }

            }
            is UiState.Error -> {

            }

            else -> {}
        }
    }

    loginViewModel.loginState.collectAsState(
        initial = UiState.Loading
    ).value.let { uiState ->
        when (uiState) {
            is UiState.Loading -> {

            }

            is UiState.Success -> {
                Toast.makeText(context, "Login Success", Toast.LENGTH_SHORT).show()
                LaunchedEffect(key1 = uiState.data.email) {
                    loginViewModel.setLoginState(UiState.Loading)
                }
                navController.navigate(Screen.Home.route)
            }

            is UiState.Error -> {
                Toast.makeText(context, "Login Failed", Toast.LENGTH_SHORT).show()
            }

            else -> {}
        }
    }

    LoginContent(onLoginWithEmailClick = {email, password ->
        loginViewModel.loginWithEmail("kyy47@gmail.com", "#Kyy47123")
    }, navController = navController)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginContent(
    onLoginWithEmailClick: (String, String) -> Unit,
    navController: NavHostController
) {

    var emailValue by remember {
        mutableStateOf("")
    }
    var passwordValue by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
                .padding(horizontal = 24.dp, vertical = 16.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ){
            Image(
                painter = painterResource(id = R.drawable.img_login),
                contentDescription = "img login",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .width(317.dp)
                    .height(291.dp)
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Yes",
                style = TextStyle(
                    fontSize = 32.sp,
                    fontWeight = FontWeight(500),
                    color = Color.Black,

                    )
            )
            Text(
                text = "Mom",
                style = TextStyle(
                    fontSize = 32.sp,
                    fontWeight = FontWeight(500),
                    color = colorResource(id = R.color.my_blue),
                    )
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                text = "Email",
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.Bold,
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 15.dp)
            )
            OutlinedTextField(
                value = emailValue,
                onValueChange = { emailValue = it },
                label = {
                    Text(
                        text = "Email anda...",
                        style = MaterialTheme.typography.titleSmall.copy(
                            fontWeight = FontWeight.Normal,
                        ),
                    )
                },
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                shape = RoundedCornerShape(20.dp),
                modifier = Modifier
                    .fillMaxWidth(),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    unfocusedBorderColor = colorResource(id = R.color.my_blue_light),
                    focusedBorderColor = colorResource(id = R.color.my_blue),
                ),


                )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                text = "Password",
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.Bold,
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 15.dp)
            )
            OutlinedTextField(
                value = passwordValue,
                onValueChange = {  passwordValue = it},
                label = {
                    Text(
                        text = "Password anda...",
                        style = MaterialTheme.typography.titleSmall.copy(
                            fontWeight = FontWeight.Normal,
                        ),
                    )
                },
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                shape = RoundedCornerShape(20.dp),
                modifier = Modifier
                    .fillMaxWidth(),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    unfocusedBorderColor = colorResource(id = R.color.my_blue_light),
                    focusedBorderColor = colorResource(id = R.color.my_blue),
                ),
                visualTransformation = if (passwordValue.trim()
                        .equals("")
                ) VisualTransformation.None else PasswordVisualTransformation()

                )
        }

        Button(
            onClick = {
                      onLoginWithEmailClick(emailValue, passwordValue)
            },
            shape = RoundedCornerShape(12.dp),
            contentPadding = PaddingValues(10.dp),
            colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.my_blue_light) ),
            modifier = Modifier
                .padding(vertical = 16.dp)
                .fillMaxWidth()
                .clipToBounds(),
        )
        {
            Text(
                text = "Masuk",
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White
                ),
            )
        }

        Text(
            text = "atau lanjutkan dengan",
            style = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight(500),
                color = Color.Black,
            )
        )

        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(8.dp))

            Image(
                painter = painterResource(id = R.drawable.img_google),
                contentDescription = "button login with google",
                contentScale = ContentScale.FillBounds,

                modifier = Modifier
                    .width(46.dp)
                    .height(46.dp)
                    .clip(CircleShape)
                    .background(colorResource(R.color.my_blue))
                    .padding(8.dp)
            )

        Text(
            text = "atau",
            style = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight(500),
                color = Color.Black,
            ),
            modifier = Modifier
                .padding(top = 8.dp)
        )

        Text(
            text = "Register",
            style = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight(600),
                color = Color.Black,
            ),
            modifier = Modifier
                .clickable { navController.navigate(Screen.Register.route) }
        )

    }
}

//@Preview(showBackground = true, device = Devices.PIXEL_4)
//@Composable
//fun LoginContentPrev() {
//    YesMomTheme {
//        LoginContent(onLoginWithEmailClick = {email, pasword->})
//    }
//}
package com.futureforge.yesmom.ui.pages.register

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import com.futureforge.yesmom.ui.pages.login.LoginViewModel
import com.futureforge.yesmom.ui.theme.YesMomTheme


@Composable
fun RegisterPage(
    context: Context,
    registerViewModel: RegisterViewModel =
        viewModel(factory = ViewModelFactory.getInstance(context)),
    navController: NavHostController
) {
    RegisterContent(onRegisterClick = {name, email, password ->
        registerViewModel.registerWithEmail(name, email, password)
    })

    registerViewModel.registerState.collectAsState(
        initial = UiState.Loading
    ).value.let { uiState ->
        when (uiState) {
            is UiState.Loading -> {

            }

            is UiState.Success -> {
                Toast.makeText(context, uiState.data.msg.toString(), Toast.LENGTH_SHORT).show()
                LaunchedEffect(key1 = uiState.data.msg) {
                    registerViewModel.setRegisterState(UiState.Loading)
                }
                navController.navigate(Screen.Login.route)
            }

            is UiState.Error -> {
                Toast.makeText(context, "Register Failed", Toast.LENGTH_SHORT).show()
                LaunchedEffect(key1 = "failed") {
                    registerViewModel.setRegisterState(UiState.Loading)
                }
            }

            else -> {}
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterContent(
    onRegisterClick : (String,String, String ) ->Unit
) {
    var emailValue by remember {
        mutableStateOf("")
    }
    var passwordValue by remember {
        mutableStateOf("")
    }

    var usernameValue by remember {
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
                painter = painterResource(id = R.drawable.img_register),
                contentDescription = "img login",
                contentScale = ContentScale.Fit,
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
                text = "Username",
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.Bold,
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 15.dp)
            )
            OutlinedTextField(
                value = usernameValue,
                onValueChange = { usernameValue = it },
                label = {
                    Text(
                        text = "Username anda...",
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
                onValueChange = { passwordValue = it },
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
                      onRegisterClick(usernameValue, emailValue, passwordValue)
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
                text = "Daftar",
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
            contentDescription = "button continue with google",
            contentScale = ContentScale.FillBounds,

            modifier = Modifier
                .width(46.dp)
                .height(46.dp)
                .clip(CircleShape)
                .background(colorResource(R.color.my_blue))
                .padding(8.dp)
        )


    }
}

//@Preview(showBackground = true, device = Devices.PIXEL_4)
//@Composable
//fun RegisterContentPrev() {
//    YesMomTheme {
//        RegisterContent()
//    }
//}
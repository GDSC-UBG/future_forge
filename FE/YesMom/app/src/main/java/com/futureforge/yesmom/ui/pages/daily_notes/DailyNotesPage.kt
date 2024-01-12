package com.futureforge.yesmom.ui.pages.daily_notes


import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
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
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.futureforge.yesmom.R
import com.futureforge.yesmom.common.UiState
import com.futureforge.yesmom.navigation.Screen
import com.futureforge.yesmom.ui.components.DialogDailyNotes
import com.futureforge.yesmom.ui.components.NotesTodaySection
import com.futureforge.yesmom.ui.factory.ViewModelFactory
import com.futureforge.yesmom.ui.pages.login.LoginViewModel
import com.futureforge.yesmom.ui.theme.YesMomTheme

@Composable
fun DailyNotesPage(
    context: Context, notesViewModel: DailyNotesViewModel =
        viewModel(factory = ViewModelFactory.getInstance(context)),
    navController: NavHostController
) {

    var emojiSelected by remember {
        mutableStateOf("")
    }



    notesViewModel.notesState.collectAsState(
        initial = UiState.Loading
    ).value.let { uiState ->
        when (uiState) {
            is UiState.Loading -> {

            }

            is UiState.Success -> {
                Toast.makeText(context, uiState.data.msg.toString(), Toast.LENGTH_SHORT).show()
                LaunchedEffect(key1 = " Success") {
                    notesViewModel.setNotesState(UiState.Loading)
                }
                navController.navigate(Screen.Home.route)
            }

            is UiState.Error -> {
                Toast.makeText(context, " Failed", Toast.LENGTH_SHORT).show()
                LaunchedEffect(key1 = "failed") {
                    notesViewModel.setNotesState(UiState.Loading)
                }
            }

            else -> {}
        }
    }
   DailyNotesContent(
       onSubmit = {text ->
           var a = 1
            if(emojiSelected == "sad"){
                a = 1
            }else
           if(emojiSelected == "bored"){
               a = 2
           }else
           if(emojiSelected == "normal"){
               a = 3
           }else
           if(emojiSelected == "happy"){
               a = 4
           }else
           if(emojiSelected == "excited"){
               a = 5
           }else{
               a = 4
           }
           notesViewModel.postNotes(text, a)
       },
       emojiSelected = emojiSelected,
       onChange = {
           emojiSelected = it
       }
   )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DailyNotesContent(
    onSubmit: (String) -> Unit,
    emojiSelected : String,
    onChange: (String) -> Unit
) {
    var isDisplayModal by remember {
        mutableStateOf(false)
    }
    var mondayState by remember {
        mutableStateOf("")
    }
    var tuesdayState by remember {
        mutableStateOf("")
    }
    var wednesdayState by remember {
        mutableStateOf("")
    }
    var thursdayState by remember {
        mutableStateOf("")
    }
    var fridayState by remember {
        mutableStateOf("")
    }
    var saturdayState by remember {
        mutableStateOf("")
    }

    var stateNow by remember {
        mutableStateOf("")
    }






    Column(
        modifier = Modifier
            .fillMaxWidth()
            .then(
                if (!isDisplayModal) {
                    Modifier.verticalScroll(rememberScrollState())
                } else {
                    Modifier.blur(radius = 8.dp)
                }
            ),

        ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 12.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Catatan Harian",
                    style = TextStyle(
                        fontSize = 24.sp,
                        fontWeight = FontWeight(700),
                        color = Color.Black,

                        )
                )
            }

        }
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(2.dp)
                .background(colorResource(R.color.my_blue_light))
        )
        Text(
            text = "Ayo isi Catatan Harian Anda",
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight(400),
                color = Color(0xFF27C0F2),
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp, horizontal = 16.dp)
        )


        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,

            ) {

            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                if (emojiSelected == "sad") {
                    Image(
                        painter = painterResource(id = R.drawable.sad_emoji),
                        contentDescription = "Sad Emoji",
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier
                            .width(35.dp)
                            .height(35.dp)

                    )
                }
                if (emojiSelected == "happy") {
                    Image(
                        painter = painterResource(id = R.drawable.happiness_emoji),
                        contentDescription = "Happy Emoji",
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier
                            .width(35.dp)
                            .height(35.dp)

                    )
                }
                if (emojiSelected == "bored") {
                    Image(
                        painter = painterResource(id = R.drawable.bored_emoji),
                        contentDescription = "Bored Emoji",
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier
                            .width(35.dp)
                            .height(35.dp)

                    )
                }
                if (emojiSelected == "normal") {
                    Image(
                        painter = painterResource(id = R.drawable.normal_emoji),
                        contentDescription = "Normal Emoji",
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier
                            .width(35.dp)
                            .height(35.dp)

                    )
                }
                if (emojiSelected == "excited") {
                    Image(
                        painter = painterResource(id = R.drawable.excited_emoji),
                        contentDescription = "Excited Emoji",
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier
                            .width(35.dp)
                            .height(35.dp)

                    )
                }

                Text(
                    text = "Sabtu",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight(500),
                        color = Color.Black,
                    ),
                )
            }

            Spacer(
                modifier = Modifier
                    .padding(vertical = 12.dp)
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(color = Color(0xFFB2ACB9))
            )

            Text(
                text = "Apa perasaan anda saat ini ?",
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight(300),
                    color = Color.Black,
                ),
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier.padding(top = 12.dp)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.sad_emoji),
                        contentDescription = "Sad Emoji",
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier
                            .width(49.dp)
                            .height(49.dp)
                            .clickable {
                                onChange(  "sad")
                            }
                    )
                    Text(
                        text = "Sedih",
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontWeight = FontWeight(300),
                            color = Color.Black,
                        ),
                    )

                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.bored_emoji),
                        contentDescription = "Bored Emoji",
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier
                            .width(49.dp)
                            .height(49.dp)
                            .clickable {
                                onChange(  "bored")
                            }
                    )
                    Text(
                        text = "Bosan",
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontWeight = FontWeight(300),
                            color = Color.Black,
                        ),
                    )

                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.normal_emoji),
                        contentDescription = "Normal Emoji",
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier
                            .width(49.dp)
                            .height(49.dp)
                            .clickable {
                                onChange(  "normal")
                            }
                    )
                    Text(
                        text = "Biasa Aja",
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontWeight = FontWeight(300),
                            color = Color.Black,
                        ),
                    )

                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.happiness_emoji),
                        contentDescription = "Happy Emoji",
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier
                            .width(49.dp)
                            .height(49.dp)
                            .clickable {
                                onChange(  "happy")
                            }
                    )
                    Text(
                        text = "Senang",
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontWeight = FontWeight(300),
                            color = Color.Black,
                        ),
                    )

                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.excited_emoji),
                        contentDescription = "Excited Emoji",
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier
                            .width(49.dp)
                            .height(49.dp)
                            .clickable {
                                onChange(  "excited")
                            }
                    )
                    Text(
                        text = "Seru",
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontWeight = FontWeight(300),
                            color = Color.Black,
                        ),
                    )

                }
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Catatan",
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.Bold,
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 15.dp)
                )
                OutlinedTextField(
                    value = saturdayState,
                    onValueChange = { saturdayState = it },
                    label = {
                        Text(
                            text = "Catatan Untuk Hari Ini...",
                            style = MaterialTheme.typography.titleSmall.copy(
                                fontWeight = FontWeight.Normal,
                            ),
                        )
                    },
                    maxLines = 5, // Set the number of lines you want to allow
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                    shape = RoundedCornerShape(20.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(130.dp),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        unfocusedBorderColor = colorResource(id = R.color.my_blue_light),
                        focusedBorderColor = colorResource(id = R.color.my_blue),
                    ),
                )

            }
            Button(
                onClick = {
                    onSubmit(saturdayState)
                },
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.my_blue_light)),
                modifier = Modifier
                    .padding(vertical = 8.dp)
                    .fillMaxWidth()
                    .clipToBounds(),
            )
            {
                Text(
                    text = "Simpan",
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.SemiBold,
                        color = Color.White
                    ),
                )
            }

//            Button(
//                onClick = {
//                    onDismissRequest()
//                },
//                shape = RoundedCornerShape(12.dp),
//                colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.my_red) ),
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(vertical = 8.dp)
//                    .clipToBounds(),
//            )
//            {
//                Text(
//                    text = "Batal",
//                    style = MaterialTheme.typography.titleMedium.copy(
//                        fontWeight = FontWeight.SemiBold,
//                        color = Color.White
//                    ),
//                )
//            }
//        }


//       NotesTodaySection(onButtonFillClick = {
//           isDisplayModal = true
//           stateNow = "monday"
//       }, state = mondayState, day = "Senin")
//
//        NotesTodaySection(onButtonFillClick = {
//            isDisplayModal = true
//            stateNow = "tuesday"
//        }, state = tuesdayState, day = "Selasa")
//
//        NotesTodaySection(onButtonFillClick = {
//            isDisplayModal = true
//            stateNow = "wednesday"
//        }, state = wednesdayState, day = "Rabu")
//
//        NotesTodaySection(onButtonFillClick = {
//            isDisplayModal = true
//            stateNow = "thursday"
//        }, state = thursdayState, day = "Kamis")
//
//        NotesTodaySection(onButtonFillClick = {
//            isDisplayModal = true
//            stateNow = "friday"
//        }, state = fridayState, day = "Jumat")
//
//
//        NotesTodaySection(onButtonFillClick = {
//            isDisplayModal = true
//            stateNow = "saturday"
//        }, state = saturdayState, day = "Sabtu")

//        if(isDisplayModal){
//           DialogDailyNotes(
//               onDismissRequest = {
//                isDisplayModal = false
//               },
//               onConfirmation = {
//                isDisplayModal = false
//               },
//               state = when(stateNow){
//                            "monday" -> mondayState
//                            "tuesday" -> tuesdayState
//                            "wednesday" -> wednesdayState
//                            "thursday" -> thursdayState
//                            "friday" -> fridayState
//                            "saturday" -> saturdayState
//                                     else ->mondayState
//                                     },
//               onChangeState = {
//                    when(stateNow){
//                        "monday" -> mondayState  = it
//                        "tuesday" -> tuesdayState = it
//                        "wednesday" -> wednesdayState = it
//                        "thursday" -> thursdayState = it
//                        "friday" -> fridayState = it
//                        "saturday" -> saturdayState = it
//                        else ->mondayState
//                    }
//               },
//               day = when(stateNow){
//                   "monday" -> "Senin"
//                   "tuesday" -> "Selasa"
//                   "wednesday" -> "Rabu"
//                   "thursday" -> "Kamis"
//                   "friday" -> "Jumat"
//                   "saturday" -> "Sabtu"
//                   else -> "Senin"
//               }
//           )
//       }

        }
    }}


//@Preview(showBackground = true, )
//@Composable
//fun DailyNotesContentPrev() {
//    YesMomTheme {
//        DailyNotesContent()
//    }
//}
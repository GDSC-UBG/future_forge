package com.futureforge.yesmom.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.futureforge.yesmom.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DialogDailyNotes(
    onDismissRequest: () -> Unit,
    onConfirmation: () -> Unit,
) {
    Dialog(onDismissRequest = { onDismissRequest() }) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White),
        ) {
            var emojiSelected by remember {
                mutableStateOf("")
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .padding(16.dp)
                ,
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,

                ) {

                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    if(emojiSelected == "sad"){
                        Image(
                            painter = painterResource(id = R.drawable.sad_emoji),
                            contentDescription = "Sad Emoji",
                            contentScale = ContentScale.FillBounds,
                            modifier = Modifier
                                .width(35.dp)
                                .height(35.dp)

                        )
                    }
                    if(emojiSelected == "happy"){
                        Image(
                            painter = painterResource(id = R.drawable.happiness_emoji),
                            contentDescription = "Happy Emoji",
                            contentScale = ContentScale.FillBounds,
                            modifier = Modifier
                                .width(35.dp)
                                .height(35.dp)

                        )
                    }
                    if(emojiSelected == "worried"){
                        Image(
                            painter = painterResource(id = R.drawable.worried_emoji),
                            contentDescription = "Worried Emoji",
                            contentScale = ContentScale.FillBounds,
                            modifier = Modifier
                                .width(35.dp)
                                .height(35.dp)

                        )
                    }

                    Text(
                        text = "Selasa",
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight(500),
                            color = Color.Black,
                        ),
                    )
                }

                Spacer(modifier = Modifier
                    .padding(vertical = 12.dp)
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(color = Color(0xFFB2ACB9)))

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
                                    emojiSelected = "sad"
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
                            painter = painterResource(id = R.drawable.worried_emoji),
                            contentDescription = "Worried Emoji",
                            contentScale = ContentScale.FillBounds,
                            modifier = Modifier
                                .width(49.dp)
                                .height(49.dp)
                                .clickable {
                                    emojiSelected = "worried"
                                }
                        )
                        Text(
                            text = "Cemas",
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
                                    emojiSelected = "happy"
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
                        value = "",
                        onValueChange = { },
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
                            onDismissRequest()
                    },
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.my_blue_light) ),
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

                Button(
                    onClick = {
                        onDismissRequest()
                    },
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.my_red) ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                        .clipToBounds(),
                )
                {
                    Text(
                        text = "Batal",
                        style = MaterialTheme.typography.titleMedium.copy(
                            fontWeight = FontWeight.SemiBold,
                            color = Color.White
                        ),
                    )
                }
            }
        }
    }

}
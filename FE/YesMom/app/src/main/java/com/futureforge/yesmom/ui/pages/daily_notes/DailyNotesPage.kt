package com.futureforge.yesmom.ui.pages.daily_notes


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
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
import com.futureforge.yesmom.R
import com.futureforge.yesmom.ui.components.DialogDailyNotes
import com.futureforge.yesmom.ui.theme.YesMomTheme

@Composable
fun DailyNotesPage() {
   DailyNotesContent()
}

@Composable
fun DailyNotesContent() {
    var isDisplayModal by remember {
        mutableStateOf(false)
    }
    Column(
        modifier = Modifier.fillMaxWidth()
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
        ) {
            Spacer(modifier = Modifier
                .blur(radius = 1.dp)
                .padding(vertical = 8.dp)
                .fillMaxWidth()
                .height(2.dp)
                .background(color = Color(0xFFB2ACB9)))
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Senin",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight(500),
                        color = Color.Black,
                    ),
                )
                Spacer(modifier = Modifier
                    .padding(vertical = 12.dp)
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(color = Color(0xFFB2ACB9)))
                Text(
                    text = "Hari ini bangun dengan perasaan lelah dan cemas. Sulit tidur semalaman karena bayi terbangun berkali-kali.",
                    style = TextStyle(
                        fontSize = 13.sp,
                        fontWeight = FontWeight(500),
                        color = Color(0xFF6F667B),
                    )
                )
            }
            Spacer(modifier = Modifier
                .blur(radius = 1.dp)
                .padding(vertical = 8.dp)
                .fillMaxWidth()
                .height(2.dp)
                .background(color = Color(0xFFB2ACB9)))
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Spacer(modifier = Modifier
                .blur(radius = 1.dp)
                .padding(vertical = 8.dp)
                .fillMaxWidth()
                .height(2.dp)
                .background(color = Color(0xFFB2ACB9)))
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Selasa",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight(500),
                        color = Color.Black,
                    ),
                )
                Spacer(modifier = Modifier
                    .padding(vertical = 12.dp)
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(color = Color(0xFFB2ACB9)))
                Button(
                    onClick = {
                              isDisplayModal = true
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(id = R.color.my_blue),
                        contentColor = Color.Black
                    )
                ) {
                    Text(
                        text = "Isi Sekarang",
                        style = MaterialTheme.typography.labelLarge.copy(
                            fontWeight = FontWeight.SemiBold,
                            textAlign = TextAlign.Start,
                            color = Color.Black
                        )
                    )
                }
            }
            Spacer(modifier = Modifier
                .blur(radius = 1.dp)
                .padding(vertical = 8.dp)
                .fillMaxWidth()
                .height(2.dp)
                .background(color = Color(0xFFB2ACB9)))
        }

       if(isDisplayModal){
           DialogDailyNotes(
               onDismissRequest = {
                isDisplayModal = false
               },
               onConfirmation = {
                isDisplayModal = false
               }
           )
       }

    }
}

@Preview(showBackground = true, )
@Composable
fun DailyNotesContentPrev() {
    YesMomTheme {
        DailyNotesContent()
    }
}
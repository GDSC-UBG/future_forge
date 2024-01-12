package com.futureforge.yesmom.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.futureforge.yesmom.R

@Composable
fun NotesTodaySection(
    onButtonFillClick : () -> Unit,
    state: String,
    day: String
) {
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
                text = day,
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
            if(state.isNullOrEmpty()){
                Button(
                    onClick = {
                        onButtonFillClick()
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
            }else{
                Text(
                    text = state,
                    style = TextStyle(
                        fontSize = 13.sp,
                        fontWeight = FontWeight(500),
                        color = Color(0xFF6F667B),
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
}
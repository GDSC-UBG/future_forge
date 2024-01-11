package com.futureforge.yesmom.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.futureforge.yesmom.R

@Composable
fun CardFeedHome() {
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
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)

        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.img_dummy_card_profile_feed),
                            contentDescription = "image card feed",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .border(
                                    width = 1.dp,
                                    color = Color(0xFF000000),
                                    shape = RoundedCornerShape(size = 200.dp)
                                )
                                .width(45.dp)
                                .height(44.92462.dp)
                                .clip(CircleShape)
                        )
                        Text(
                            text = "Tania",
                            style = TextStyle(
                                fontSize = 16.sp,
                                fontWeight = FontWeight(700),
                                color = Color.Black,

                                )
                        )

                    }
                    Button(
                        onClick = { /*TODO*/ },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = colorResource(id = R.color.my_blue),
                            contentColor = Color.Black
                        )
                    ) {
                        Text(
                            text = "ikuti",
                            style = MaterialTheme.typography.labelLarge.copy(
                                fontWeight = FontWeight.SemiBold,
                                textAlign = TextAlign.Start,
                                color = Color.Black
                            )
                        )
                    }
                }
                Spacer(modifier = Modifier
                    .padding(vertical = 12.dp)
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(color = Color(0xFFB2ACB9)))
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Meski terkadang lelah dan cemas, setiap langkah merawat anak adalah bukti keberanian dan cinta tanpa batas. Kita, sebagai ibu, adalah pahlawan bagi mereka. Temukan kekuatan dalam pelukan kecil anak",
                    style = MaterialTheme.typography.labelMedium.copy(
                        fontWeight = FontWeight.Normal,
                    ),
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis,
                )
                Text(
                    text = "Selengkapnya...",
                    style = MaterialTheme.typography.labelLarge.copy(
                        fontWeight = FontWeight.SemiBold,
                        textAlign = TextAlign.Start,
                        color = colorResource(R.color.my_blue)
                    )
                )

                Image(
                    painter = painterResource(id = R.drawable.img_dummy_card_content_feed),
                    contentDescription = "image content feed",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .padding(top = 24.dp)
                        .width(333.dp)
                        .height(255.dp)
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


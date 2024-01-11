package com.futureforge.yesmom.ui.pages.home

import android.content.Context
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
import androidx.compose.runtime.LaunchedEffect
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
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.futureforge.yesmom.R
import com.futureforge.yesmom.navigation.Screen
import com.futureforge.yesmom.ui.components.CardFeedHome
import com.futureforge.yesmom.ui.factory.ViewModelFactory
import com.futureforge.yesmom.ui.theme.YesMomTheme
import kotlinx.coroutines.CoroutineScope

@Composable
fun HomePage(context: Context,
             homeViewModel: HomeViewModel =
                  viewModel(factory = ViewModelFactory.getInstance(context)),
             navController: NavHostController
             ) {

    HomeContent()

}


@Composable
fun HomeContent() {
    Column(
        modifier = Modifier.fillMaxWidth(),

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
                    text = "Yes",
                    style = TextStyle(
                        fontSize = 24.sp,
                        fontWeight = FontWeight(700),
                        color = Color.Black,

                        )
                )
                Text(
                    text = "Mom",
                    style = TextStyle(
                        fontSize = 24.sp,
                        fontWeight = FontWeight(700),
                        color = colorResource(id = R.color.my_blue),
                    )
                )
            }
            Image(
                painter = painterResource(id = R.drawable.img_dummy_profile_home),
                contentDescription = "image profile",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(50.dp)
                    .height(50.dp)
                    .clip(CircleShape)
            )


        }
        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(2.dp)
            .background(colorResource(R.color.my_blue_light))
        )
        CardFeedHome()


    }
}

@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun HomeContentPrev() {
    YesMomTheme {
        HomeContent()
    }
}



//Button(onClick = {
//    homeViewModel.deleteToken()
//    navController.navigate(Screen.Login.route)
//}) {
//    Text(text = "Keluar")
//}
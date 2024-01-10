package com.futureforge.yesmom.ui.pages.home

import android.content.Context
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.futureforge.yesmom.navigation.Screen
import com.futureforge.yesmom.ui.factory.ViewModelFactory
import kotlinx.coroutines.CoroutineScope

@Composable
fun HomePage(context: Context,
             homeViewModel: HomeViewModel =
                  viewModel(factory = ViewModelFactory.getInstance(context)),
             navController: NavHostController
             ) {
    Button(onClick = {
        homeViewModel.deleteToken()
                navController.navigate(Screen.Login.route)
    }) {
        Text(text = "Keluar")
    }
}
package com.futureforge.yesmom.ui.pages.profile

import android.content.Context
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.futureforge.yesmom.navigation.Screen
import com.futureforge.yesmom.ui.factory.ViewModelFactory
import com.futureforge.yesmom.ui.pages.home.HomeViewModel

@Composable
fun ProfilePage(context: Context,
                profileViewModel: ProfileViewModel =
                    viewModel(factory = ViewModelFactory.getInstance(context)),
                navController: NavHostController
) {
    Button(onClick = {
    profileViewModel.deleteToken()
    navController.navigate(Screen.Login.route)
}) {
    Text(text = "Keluar")
}
}
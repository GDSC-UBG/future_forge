package com.futureforge.yesmom

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.futureforge.yesmom.navigation.Screen
import com.futureforge.yesmom.ui.components.BottomBar
import com.futureforge.yesmom.ui.pages.home.HomePage
import com.futureforge.yesmom.ui.pages.login.LoginPage
import com.futureforge.yesmom.ui.pages.register.RegisterPage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun YesMomApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val context = LocalContext.current
    Scaffold(
        bottomBar = {
            when(currentRoute){
                Screen.Login.route -> {}
                Screen.Register.route -> {}
                else ->  BottomBar(navController = navController)
            }

        },
        modifier = modifier
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Login.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.Home.route) {
                HomePage(context, navController = navController)
            }
            composable(Screen.Login.route) {
                LoginPage(
                    context = context,
                    navController = navController
                    )
            }
            composable(Screen.Register.route) {
                RegisterPage()
            }
        }
    }
}
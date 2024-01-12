package com.futureforge.yesmom

import android.Manifest
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.futureforge.yesmom.navigation.Screen
import com.futureforge.yesmom.service.comp.FirebaseMessagingNotificationPermissionDialog
import com.futureforge.yesmom.ui.components.BottomBar
import com.futureforge.yesmom.ui.pages.calendar.CalendarPage
import com.futureforge.yesmom.ui.pages.daily_notes.DailyNotesPage
import com.futureforge.yesmom.ui.pages.find_doctor.FindDoctorPage
import com.futureforge.yesmom.ui.pages.home.HomePage
import com.futureforge.yesmom.ui.pages.login.LoginPage
import com.futureforge.yesmom.ui.pages.profile.ProfilePage
import com.futureforge.yesmom.ui.pages.register.RegisterPage
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import com.google.firebase.Firebase
import com.google.firebase.messaging.messaging

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class, ExperimentalPermissionsApi::class)
@Composable
fun YesMomApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    val showNotificationDialog = remember { mutableStateOf(false) }

    // Android 13 Api 33 - runtime notification permission has been added
    val notificationPermissionState = rememberPermissionState(
        permission = Manifest.permission.POST_NOTIFICATIONS
    )
    if (showNotificationDialog.value) FirebaseMessagingNotificationPermissionDialog(
        showNotificationDialog = showNotificationDialog,
        notificationPermissionState = notificationPermissionState
    )

    LaunchedEffect(key1=Unit){
        if (notificationPermissionState.status.isGranted ||
            Build.VERSION.SDK_INT < Build.VERSION_CODES.TIRAMISU
        ) {
            Firebase.messaging.subscribeToTopic("Tutorial")
        } else showNotificationDialog.value = true
    }

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
                RegisterPage(context, navController = navController)
            }
            composable(Screen.FindDoctor.route) {
                FindDoctorPage()
            }
            composable(Screen.Calendar.route) {
                CalendarPage(  context = context,
                    navController = navController)
            }
            composable(Screen.DailyNotes.route) {
                DailyNotesPage(  context = context,
                    navController = navController)
            }
            composable(Screen.Profile.route) {
                ProfilePage(   context = context,
                    navController = navController)
            }
        }
    }
}
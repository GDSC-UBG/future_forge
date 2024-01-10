package com.futureforge.yesmom.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.futureforge.yesmom.R
import com.futureforge.yesmom.navigation.NavigationItem
import com.futureforge.yesmom.navigation.Screen
import com.futureforge.yesmom.ui.theme.YesMomTheme

@Composable
fun BottomBar(
    modifier: Modifier = Modifier, navController: NavHostController
) {

    NavigationBar(
        modifier = modifier
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        val navigationItems = listOf(
            NavigationItem(
                title = stringResource(R.string.menu_home),
                icon = Icons.Default.Home,
                screen = Screen.Home
            ),

        )
        navigationItems.map { item ->
            NavigationBarItem(selected = item.screen.route == currentRoute, onClick = {
                navController.navigate(item.screen.route) {
                    popUpTo(navController.graph.findStartDestination().id) {
                        saveState = true
                    }
                    restoreState = true
                    launchSingleTop = true
                }
            }, icon = {
                Icon(
                    imageVector = item.icon, contentDescription = item.title
                )
            }, label = { Text(text = item.title) })
        }
    }
}


@Preview(showBackground = true)
@Composable
fun BottomBarPreview() {
    YesMomTheme {
        BottomBar(navController = rememberNavController())
    }
}

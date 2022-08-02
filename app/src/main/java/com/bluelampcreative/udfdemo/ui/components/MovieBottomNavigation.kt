package com.bluelampcreative.udfdemo.ui.components

import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.bluelampcreative.udfdemo.nav.bottomNavigationItems

@Composable
fun MovieBottomNavigation(navigationController: NavHostController) {

    BottomAppBar(
        cutoutShape = MaterialTheme.shapes.small.copy(CornerSize(percent = 50))
    ) {

        val navBackStackEntry by navigationController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        bottomNavigationItems.forEach { bottomNavigationItem ->
            BottomNavigationItem(
                icon = {
                    Icon(
                       bottomNavigationItem.icon,
                        contentDescription = bottomNavigationItem.iconDescription
                    )
                },
                label = { Text(bottomNavigationItem.iconDescription) },
                selected = currentRoute == bottomNavigationItem.route,
                onClick = {
                    navigationController.navigate(bottomNavigationItem.route) {
                        popUpTo(navigationController.graph.id)
                        launchSingleTop = true
                    }
                }
            )
        }
    }
}
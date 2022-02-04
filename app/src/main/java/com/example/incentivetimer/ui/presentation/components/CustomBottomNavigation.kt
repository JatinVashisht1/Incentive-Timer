package com.example.incentivetimer.ui.presentation.components

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.incentivetimer.core.Screen

@Composable
fun CustomBottomNavigation(
    navController: NavController,
    items: List<Screen>
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    BottomNavigation(
        backgroundColor = if (isSystemInDarkTheme()) Color(0xFF023047) else Color(0xFF219ebc)
    ) {
        items.forEach { screen ->
            BottomNavigationItem(
                selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                onClick = {
                    navController.navigate(screen.route) {
                        // Pop up to the start destination of the graph to
                        // avoid building up a large stack of destinations
                        // on the back stack as users select items
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        // Avoid multiple copies of the same destination when
                        // re-selecting the same item
                        launchSingleTop = true
                        // Restore state when re-selecting a previously selected item
                        restoreState = true
                    }
                },
                icon = {
                    if (currentDestination?.hierarchy?.any { it.route == screen.route } == true) {
                        Icon(
                            imageVector = screen.onSelected,
                            contentDescription = screen.route,
                            tint = Color.White
                        )
                    } else {
                        Icon(
                            imageVector = screen.onNotSelected,
                            contentDescription = screen.route,
                            tint = Color.White
                        )
                    }
                },
                alwaysShowLabel = false,
                label = {
                    Text(
                        text = screen.label,
                        color = Color.White
                    )
                },
            )
        }
    }
}
package com.example.incentivetimer.core

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.List
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(
    val route: String,
    val onSelected: ImageVector,
    val onNotSelected: ImageVector,
    val label: String
) {
    object HomeScreen : Screen(
        route = "HomeScreen",
        onSelected = Icons.Filled.Home,
        onNotSelected = Icons.Outlined.Home,
        label = "Home"
    )

    object RewardListScreen : Screen(
        route = "RewardListScreen",
        onSelected = Icons.Filled.List,
        onNotSelected = Icons.Outlined.List,
        label = "Detail"
    )
}

package com.example.incentivetimer.ui.presentation

import android.net.wifi.WifiManager
import android.os.Bundle
import android.provider.Settings.Global.putString
import android.provider.Settings.Secure.putString
import android.provider.Settings.System.putString
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.rememberScaffoldState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.incentivetimer.core.Screen
import com.example.incentivetimer.ui.presentation.components.CustomBottomNavigation
import com.example.incentivetimer.ui.presentation.reward_list_screen.RewardListScreen
import com.example.incentivetimer.ui.presentation.timer_screen.TimerScreen
import com.example.incentivetimer.ui.theme.IncentiveTimerTheme
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ITActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setTheme(android.R.style.ThemeOverlay_Material_Dark)
        setContent {
            IncentiveTimerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = if (isSystemInDarkTheme()) Color(0xff023047) else Color(0xff219ebc)
                ) {
                    val navController = rememberAnimatedNavController()
                    val scaffoldState = rememberScaffoldState()
                    Scaffold(
                        scaffoldState = scaffoldState,
                        bottomBar = {
                            CustomBottomNavigation(
                                navController = navController,
                                items = listOf(Screen.HomeScreen, Screen.RewardListScreen)
                            )
                        },
                    ) {
                        AnimatedNavHost(
                            enterTransition = { EnterTransition.None },
                            exitTransition = { ExitTransition.None },
                            popEnterTransition = { EnterTransition.None },
                            popExitTransition = { ExitTransition.None },
                            navController = navController,
                            startDestination = Screen.HomeScreen.route
                        ) {
                            composable(route = Screen.HomeScreen.route) {
                                TimerScreen()
                            }
                            composable(route = Screen.RewardListScreen.route) {
                                RewardListScreen()
                            }
                        }
                    }
                }
            }
        }
    }
}

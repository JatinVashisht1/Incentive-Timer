package com.example.incentivetimer.ui.presentation.timer_screen

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun TimerScreen() {
    ScreenContent()
}

@Composable
fun ScreenContent() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Timer") },
                backgroundColor = if (isSystemInDarkTheme()) Color(0xFF023047) else Color(0xFF219ebc)
            )
        }
    ) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text("Timer")
        }
    }
}


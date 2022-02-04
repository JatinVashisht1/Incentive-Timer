package com.example.incentivetimer.ui

import android.graphics.Bitmap
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cake
import androidx.compose.material.icons.filled.Smartphone
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Tv
import androidx.compose.ui.graphics.vector.ImageVector

object IconKeys {
    const val CAKE = "CAKE"
    const val TV = "TV"
    const val SMARTPHONE = "SMARTPHONE"
}

enum class IconKey {
    CAKE,
    TV,
    SMARTPHONE,
    STAR
}

fun iconKeyToIcon(iconKey: IconKey): ImageVector =
    when (iconKey) {
        IconKey.CAKE -> {
            Icons.Default.Cake
        }
        IconKey.TV -> {
            Icons.Default.Tv
        }
        IconKey.SMARTPHONE -> {
            Icons.Default.Smartphone
        }
        IconKey.STAR -> {
            Icons.Default.Star
        }
    }


fun stringToIconKey(string: String): IconKey = when (string) {
        "CAKE" -> {
            IconKey.CAKE
        }
        "TV" -> {
            IconKey.TV
        }
        "SMARTPHONE" -> {
            IconKey.SMARTPHONE
        }
        else -> {
            IconKey.STAR
        }
    }

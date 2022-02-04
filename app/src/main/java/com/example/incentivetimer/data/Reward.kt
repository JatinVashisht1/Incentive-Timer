package com.example.incentivetimer.data

import androidx.compose.ui.graphics.vector.ImageVector
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "rewards_table")
data class Reward(
    val iconKey: String,
    val title: String,
    val chancePercent: Int,
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
)

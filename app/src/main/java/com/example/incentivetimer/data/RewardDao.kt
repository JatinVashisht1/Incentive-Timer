package com.example.incentivetimer.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface RewardDao {

    @Query("SELECT * FROM rewards_table")
    fun getAllRewards() : Flow<List<Reward>>

    @Delete
    suspend fun deleteReward(reward: Reward)

    @Insert(onConflict = REPLACE)
    suspend fun insertReward(reward: Reward)



}
package com.example.incentivetimer.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cake
import androidx.compose.material.icons.filled.Smartphone
import androidx.compose.material.icons.filled.Tv
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.incentivetimer.di.ApplicationScope
import com.example.incentivetimer.ui.IconKey
import com.example.incentivetimer.ui.IconKeys
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider

@Database(entities = [Reward::class], version = 1, exportSchema = false)
abstract class ITDatabase : RoomDatabase() {
    abstract fun rewardDao(): RewardDao

    companion object {
        const val DATABASE_NAME = "it_db"
    }

    class Callback @Inject constructor(
        @ApplicationScope private val scope: CoroutineScope,
        private val database: Provider<ITDatabase>// Provider belongs to dagger, this is way to declare it lazily, it will be instantiated when we will call it (after onCreate here) ,
        // we will instantiate it after onCreate because then dagger will get some time to provide database
    ) : RoomDatabase.Callback() {
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)

            val rewardDao = database.get().rewardDao()// database will be instantiate by calling .get()
            scope.launch {
                rewardDao.insertReward(Reward(iconKey = IconKey.CAKE.name, title = "Eat a piece of cake", chancePercent = 5))
                rewardDao.insertReward(Reward(iconKey = IconKey.TV.name, title = "Watch 1 episode of my favourite TV/Web series", chancePercent = 7))
                rewardDao.insertReward(Reward(iconKey = IconKey.SMARTPHONE.name, title = "Use mobile for 10 minuets", chancePercent = 9))
                rewardDao.insertReward(Reward(iconKey = IconKey.SMARTPHONE.name, title = "Use mobile for 10 minuets", chancePercent = 9))
                rewardDao.insertReward(Reward(iconKey = IconKey.SMARTPHONE.name, title = "Use mobile for 10 minuets", chancePercent = 9))
                rewardDao.insertReward(Reward(iconKey = IconKey.SMARTPHONE.name, title = "Use mobile for 10 minuets", chancePercent = 9))
                rewardDao.insertReward(Reward(iconKey = IconKey.SMARTPHONE.name, title = "Use mobile for 10 minuets", chancePercent = 9))
                rewardDao.insertReward(Reward(iconKey = IconKey.SMARTPHONE.name, title = "Use mobile for 10 minuets", chancePercent = 9))
                rewardDao.insertReward(Reward(iconKey = IconKey.SMARTPHONE.name, title = "Use mobile for 10 minuets", chancePercent = 9))
                rewardDao.insertReward(Reward(iconKey = IconKey.SMARTPHONE.name, title = "Use mobile for 10 minuets", chancePercent = 9))
                rewardDao.insertReward(Reward(iconKey = IconKey.SMARTPHONE.name, title = "Use mobile for 10 minuets", chancePercent = 9))
            }
        }
    }
}
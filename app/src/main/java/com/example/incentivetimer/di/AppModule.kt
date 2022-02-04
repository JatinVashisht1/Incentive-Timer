package com.example.incentivetimer.di

import android.app.Application
import androidx.room.Room
import com.example.incentivetimer.data.ITDatabase
import com.example.incentivetimer.data.RewardDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    // not made it singleton because dao is by default singleton
    fun providesDao(itDatabase: ITDatabase) : RewardDao = itDatabase.rewardDao()

    @Provides
    @Singleton
    fun provideITDatabase(
        app: Application,
        callback: ITDatabase.Callback
    ): ITDatabase =
        Room.databaseBuilder(
            app,
            ITDatabase::class.java,
            ITDatabase.DATABASE_NAME
        )
            .addCallback(callback)
            .build()

    @ApplicationScope
    @Singleton
    @Provides
    fun provideApplicationScope() = CoroutineScope(SupervisorJob())
}

@Retention(AnnotationRetention.RUNTIME)
@Qualifier
annotation class ApplicationScope

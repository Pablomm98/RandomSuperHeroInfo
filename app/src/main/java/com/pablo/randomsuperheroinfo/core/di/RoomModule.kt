package com.pablo.randomsuperheroinfo.core.di

import android.content.Context
import androidx.room.Room
import com.pablo.randomsuperheroinfo.data.database.SuperHeroInfoDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    private const val DATABASE_NAME = "superhero_info_database"

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, SuperHeroInfoDatabase::class.java, DATABASE_NAME).build()

    @Singleton
    @Provides
    fun provideHeroDao(db: SuperHeroInfoDatabase) = db.getHeroDao()
}

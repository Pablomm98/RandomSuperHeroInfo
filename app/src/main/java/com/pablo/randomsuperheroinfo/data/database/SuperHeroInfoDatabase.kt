package com.pablo.randomsuperheroinfo.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.pablo.randomsuperheroinfo.data.database.dao.HeroDao
import com.pablo.randomsuperheroinfo.data.database.entities.HeroEntity

@Database(
    entities = [
        HeroEntity::class
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class SuperHeroInfoDatabase : RoomDatabase() {
    abstract fun getHeroDao(): HeroDao
}

package com.pablo.randomsuperheroinfo.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.pablo.randomsuperheroinfo.data.database.dao.HeroDao
import com.pablo.randomsuperheroinfo.data.database.entities.HeroEntity

//Clase abstracta que representa la base de datos de la aplicación utilizando Room
@Database(
    entities = [
        HeroEntity::class
    ],
    version = 2,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class SuperHeroInfoDatabase : RoomDatabase() {
    abstract fun getHeroDao(): HeroDao
}

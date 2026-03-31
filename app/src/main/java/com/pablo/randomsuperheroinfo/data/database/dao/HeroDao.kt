package com.pablo.randomsuperheroinfo.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.pablo.randomsuperheroinfo.data.database.entities.HeroEntity

//Interfaz para acceder a la base de datos utilizando Room y una corrutina en un hilo secundario
@Dao
interface HeroDao {
    @Query("SELECT * FROM hero_table ORDER BY id ASC")
    suspend fun getAllHeroes(): List<HeroEntity>

    @Query("SELECT * FROM hero_table WHERE id = :id")
    suspend fun getHeroById(id: String): HeroEntity

    @Query("DELETE FROM hero_table")
    suspend fun deleteAllHeroes()

    @Query("DELETE FROM hero_table WHERE id = :id")
    suspend fun deleteHeroById(id: Int)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHero(hero: HeroEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(quotes:List<HeroEntity>)
}
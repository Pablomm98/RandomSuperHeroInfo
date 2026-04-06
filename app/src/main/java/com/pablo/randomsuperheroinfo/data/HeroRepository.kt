package com.pablo.randomsuperheroinfo.data

import com.pablo.randomsuperheroinfo.data.database.dao.HeroDao
import com.pablo.randomsuperheroinfo.data.database.entities.HeroEntity
import com.pablo.randomsuperheroinfo.data.model.HeroModel
import com.pablo.randomsuperheroinfo.data.network.HeroService
import com.pablo.randomsuperheroinfo.domain.model.Hero
import com.pablo.randomsuperheroinfo.domain.model.toDomain
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

//Clase para obtener un héroe por su ID o por su nombre de la API utilizando Retrofit y una corrutina en un hilo secundario
class HeroRepository @Inject constructor(private val api: HeroService, private val heroDao: HeroDao) {

    suspend fun getHeroByIdFromApi(id: String): List<Hero> {
        //Se obtiene el héroe por su ID utilizando el servicio de la API
        val response: List<HeroModel> = listOf<HeroModel>(api.getHeroById(id))
        return response.map { it.toDomain() }
    }

    fun getHeroByIdFromDatabase(id: String): Flow<Hero> {
        //Se obtiene el héroe por su ID utilizando el DAO de la base de datos y se guarda en el proveedor de datos en memoria
        return heroDao.getHeroById(id).map { it.toDomain() }
    }

    suspend fun insertHeroToDatabase(heroEntity: HeroEntity) {
        heroDao.insertHero(heroEntity)
    }

    suspend fun insertHerosToDatabase(heroes: List<HeroEntity>) {
        heroDao.insertAll(heroes)
    }

    suspend fun clearHeroDatabase() {
        heroDao.deleteAllHeroes()
    }
}
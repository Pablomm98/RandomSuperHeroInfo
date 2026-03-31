package com.pablo.randomsuperheroinfo.domain

import com.pablo.randomsuperheroinfo.data.HeroRepository
import com.pablo.randomsuperheroinfo.data.database.entities.toDatabase
import com.pablo.randomsuperheroinfo.domain.model.Hero
import javax.inject.Inject

//Caso de uso para obtener un héroe por su ID
class GetHeroByIdUseCase @Inject constructor(private val repository: HeroRepository) {

    //Función para obtener un héroe por su ID utilizando el repositorio de datos y la base de datos
    suspend operator fun invoke(): Hero {
        val id = (1..731).random().toString()
        val hero = repository.getHeroByIdFromApi(id)
        return if (hero.isNotEmpty()) {
            repository.clearHeroDatabase()
            repository.insertHerosToDatabase(hero.map { it.toDatabase() })
            hero.first()
        } else {
            repository.getHeroByIdFromDatabase(id).first()
        }
    }
}
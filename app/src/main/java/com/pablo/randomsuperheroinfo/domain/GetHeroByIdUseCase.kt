package com.pablo.randomsuperheroinfo.domain

import com.pablo.randomsuperheroinfo.data.HeroRepository
import com.pablo.randomsuperheroinfo.data.model.HeroModel
import javax.inject.Inject

//Caso de uso para obtener un héroe por su ID
class GetHeroByIdUseCase @Inject constructor(private val repository: HeroRepository) {

    //Función para obtener un héroe por su ID utilizando el repositorio de datos
    suspend operator fun invoke(): HeroModel {
        val id = (1..731).random().toString()
        return repository.getHeroByIdFromApi(id)
    }
}
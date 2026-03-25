package com.pablo.randomsuperheroinfo.domain

import com.pablo.randomsuperheroinfo.data.HeroRepository
import com.pablo.randomsuperheroinfo.data.model.HeroModel
import javax.inject.Inject

//Caso de uso para obtener un héroe por su nombre
class GetHeroByNameUseCase @Inject constructor(private val repository: HeroRepository) {

    //Función para obtener un héroe por su nombre utilizando el repositorio de datos
    suspend operator fun invoke(name: String): HeroModel? = repository.getHeroByName(name)
}
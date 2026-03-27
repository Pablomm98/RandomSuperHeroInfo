package com.pablo.randomsuperheroinfo.data

import com.pablo.randomsuperheroinfo.data.model.HeroModel
import com.pablo.randomsuperheroinfo.data.model.HeroProvider
import com.pablo.randomsuperheroinfo.data.network.HeroService
import javax.inject.Inject

//Clase para obtener un héroe por su ID o por su nombre de la API utilizando Retrofit y una corrutina en un hilo secundario
class HeroRepository @Inject constructor(private val api: HeroService, private val heroProvider: HeroProvider) {

    suspend fun getHeroByIdFromApi(id: String): HeroModel {
        //Se obtiene el héroe por su ID utilizando el servicio de la API y se guarda en el proveedor de datos en memoria
        val response: HeroModel = api.getHeroById(id)
        //Se guarda el héroe en el proveedor de datos en memoria
        heroProvider.hero = response
        return response
    }

    suspend fun getHeroByNameFromApi(name: String): HeroModel {
        //Se obtiene el héroe por su nombre utilizando el servicio de la API y se guarda en el proveedor de datos en memoria
        val response: HeroModel = api.getHeroByName(name)
        //Se guarda el héroe en el proveedor de datos en memoria
        heroProvider.hero = response
        return response
    }
}
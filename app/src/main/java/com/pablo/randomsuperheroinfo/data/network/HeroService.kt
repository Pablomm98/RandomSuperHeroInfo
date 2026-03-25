package com.pablo.randomsuperheroinfo.data.network

import com.pablo.randomsuperheroinfo.data.model.HeroModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

//Clase para obtener un héroe por su ID o por su nombre de la API utilizando Retrofit y una corrutina en un hilo secundario
class HeroService @Inject constructor(private val api: HeroApiClient) {

    suspend fun getHeroById(id: String): HeroModel {
        //Función para obtener un héroe por su ID utilizando Retrofit y una corrutina en un hilo secundario
        return withContext(Dispatchers.IO) {
            val response = api.getHeroById(id)
            response.body() ?: TODO()
        }
    }

    suspend fun getHeroByName(name: String): HeroModel {
        //Función para obtener un héroe por su nombre utilizando Retrofit y una corrutina en un hilo secundario
        return withContext(Dispatchers.IO) {
            val response = api.getHeroByName(name)
            response.body() ?: TODO()
        }
    }
}
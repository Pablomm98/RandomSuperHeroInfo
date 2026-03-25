package com.pablo.randomsuperheroinfo.data.network

import com.pablo.randomsuperheroinfo.core.RetrofitHelper
import com.pablo.randomsuperheroinfo.data.model.HeroModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

//Clase para obtener un héroe por su ID o por su nombre de la API utilizando Retrofit y una corrutina en un hilo secundario
class HeroService {
    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getHeroById(id: String): HeroModel {
        //Función para obtener un héroe por su ID utilizando Retrofit y una corrutina en un hilo secundario
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(HeroApiClient::class.java).getHeroById(id)
            response.body() ?: TODO()
        }
    }

    suspend fun getHeroByName(name: String): HeroModel {
        //Función para obtener un héroe por su nombre utilizando Retrofit y una corrutina en un hilo secundario
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(HeroApiClient::class.java).getHeroByName(name)
            response.body() ?: TODO()
        }
    }
}
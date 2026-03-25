package com.pablo.randomsuperheroinfo.data.network

import com.pablo.randomsuperheroinfo.data.model.HeroModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

//Interfaz para definir la llamada a la API
interface HeroApiClient {
    //Función para obtener un héroe por su ID
    @GET("/api/cf5e8ca045cc8adf04536812f95d0e20/{id}")
    suspend fun getHeroById(@Path("id") id: String): Response<HeroModel>

    //Función para obtener un héroe por su nombre
    @GET("/api/cf5e8ca045cc8adf04536812f95d0e20/search/{name}")
    suspend fun getHeroByName(@Path("name") id: String): Response<HeroModel>
}
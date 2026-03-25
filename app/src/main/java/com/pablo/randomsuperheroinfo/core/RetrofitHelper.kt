package com.pablo.randomsuperheroinfo.core

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//Función para crear una instancia de Retrofit con la URL base de la API
object RetrofitHelper {
    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://superheroapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}
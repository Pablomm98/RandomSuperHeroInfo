package com.pablo.randomsuperheroinfo.core.di

import com.pablo.randomsuperheroinfo.data.network.HeroApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

//Módulo para la inyección de dependencias utilizando Dagger Hilt y Retrofit
@Module
@InstallIn(SingletonComponent::class) //Alcance de la instancia de Dagger Hilt a nivel de aplicación
object NetworkModule {

    //Función para proporcionar una instancia de Retrofit
    @Singleton //Singleton para la instancia de Retrofit a nivel de aplicación para evitar múltiples instancias (se va manteniendo la instancia en el tiempo, sin crear más)
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://superheroapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    //Función para proporcionar una instancia de HeroApiClient
    @Singleton
    @Provides
    fun provideHeroApiClient(retrofit: Retrofit): HeroApiClient {
        return retrofit.create(HeroApiClient::class.java)
    }
}
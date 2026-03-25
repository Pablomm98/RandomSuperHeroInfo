package com.pablo.randomsuperheroinfo.data.model

import javax.inject.Inject
import javax.inject.Singleton

//Clase para obtener un héroe por su ID o por su nombre de la API utilizando Retrofit y una corrutina en un hilo secundario
@Singleton //Singleton para la instancia en HeroRepository a nivel de aplicación para evitar múltiples instancias (se va manteniendo la instancia en el tiempo, sin crear más)
class HeroProvider @Inject constructor() {
    var hero: HeroModel? = null
}
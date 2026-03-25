package com.pablo.randomsuperheroinfo.data.model

//Clase para obtener un héroe por su ID o por su nombre de la API utilizando Retrofit y una corrutina en un hilo secundario
class HeroProvider {
    companion object {
        var hero: HeroModel? = null
    }
}
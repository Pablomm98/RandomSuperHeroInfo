package com.pablo.randomsuperheroinfo

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

//Clase de aplicación que utiliza Dagger Hilt para inyectar dependencias en la aplicación
@HiltAndroidApp
class RandomSuperHeroInfoApp: Application()
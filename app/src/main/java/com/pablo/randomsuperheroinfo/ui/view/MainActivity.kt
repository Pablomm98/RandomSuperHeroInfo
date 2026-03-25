package com.pablo.randomsuperheroinfo.ui.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.pablo.randomsuperheroinfo.ui.theme.RandomSuperHeroInfoTheme
import com.pablo.randomsuperheroinfo.ui.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

//Clase principal de la actividad de la aplicación que utiliza Dagger Hilt para inyectar dependencias en la actividad
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RandomSuperHeroInfoTheme {
                MainScreen(mainViewModel)
            }
        }
    }
}
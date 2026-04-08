package com.pablo.randomsuperheroinfo.ui.viewmodel

import android.util.Log
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.pablo.randomsuperheroinfo.domain.GetHeroByIdUseCase
import com.pablo.randomsuperheroinfo.domain.model.Hero
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.mockk
import io.mockk.mockkStatic
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

//Clase de prueba para el ViewModel de la pantalla principal
@ExperimentalCoroutinesApi
class MainViewModelTest {

    //Variables de prueba mockkeadas con RelaxedMockk para simular el comportamiento de las dependencias
    @RelaxedMockK
    private lateinit var getHeroByIdUseCase: GetHeroByIdUseCase
    //ViewModel a testear
    private lateinit var viewModel: MainViewModel

    //Regla para poder ejecutar las tareas en el hilo principal
    @get:Rule
    var rule: InstantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun onBefore() {
        MockKAnnotations.init(this)
        //Mockear Log para evitar errores en tests unitarios al intentar imprimir en consola
        mockkStatic(Log::class)
        coEvery { Log.d(any(), any()) } returns 0

        //Configuración de Dispatchers ANTES de crear el ViewModel para que se ejecuten las tareas en el hilo principal
        Dispatchers.setMain(Dispatchers.Unconfined)
        viewModel = MainViewModel(getHeroByIdUseCase)
    }

    @After
    fun onAfter() {
        //Restablecer el hilo principal de la prueba después de cada prueba para evitar problemas
        Dispatchers.resetMain()
    }

    //Función de prueba cuando getRandomHeroById es llamada y devuelve un héroe
    @Test
    fun `when getRandomHeroById is called then uiState is updated`() = runTest {
        //Given
        val hero = mockk<Hero>(relaxed = true)
        coEvery { getHeroByIdUseCase() } returns hero

        //When
        viewModel.getRandomHeroById()

        //Then
        assert(viewModel.uiState.value.hero == hero)
    }

    //Función de prueba cuando getRandomHeroById es llamada y lanza una excepción
    @Test
    fun `when getRandomHeroById is called then uiState is updated with error message`() = runTest {
        //Given
        coEvery { getHeroByIdUseCase() } throws Exception("Error al obtener el Héroe")

        //When
        viewModel.getRandomHeroById()

        //Then
        assert(viewModel.uiState.value.error == "Error al obtener el Héroe")
    }
}
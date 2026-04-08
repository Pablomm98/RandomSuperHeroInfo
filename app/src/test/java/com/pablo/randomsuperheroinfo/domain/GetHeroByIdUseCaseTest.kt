package com.pablo.randomsuperheroinfo.domain

import com.pablo.randomsuperheroinfo.data.HeroRepository
import com.pablo.randomsuperheroinfo.domain.model.Hero
import org.junit.Before
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.mockk
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.junit.Test

//Clase de prueba para el caso de uso de obtener un héroe por su ID
class GetHeroByIdUseCaseTest {

    //Variables de prueba mockkeadas con RelaxedMockk para simular el comportamiento de las dependencias
    @RelaxedMockK
    private lateinit var heroRepository: HeroRepository
    lateinit var getHeroByIdUseCase: GetHeroByIdUseCase

    //Función para inicializar las variables de prueba antes de cada prueba (la clase a testear o el viewmodel)
    @Before
    fun onBefore() {
        MockKAnnotations.init(this)
        getHeroByIdUseCase = GetHeroByIdUseCase(heroRepository)
    }

    //Función de prueba para obtener un héroe por su ID cuando la API devuelve una lista vacía
    @Test
    fun `when the Api doesn't return anything then get values from Database`() = runBlocking {
        //Given
        val hero = mockk<Hero>(relaxed = true)
        coEvery { heroRepository.getHeroByIdFromApi(any()) } returns emptyList()
        coEvery { heroRepository.getHeroByIdFromDatabase(any()) } returns flowOf(hero)

        //When
        getHeroByIdUseCase()

        //Then
        coVerify(exactly = 1) { heroRepository.getHeroByIdFromDatabase(any()) }
    }

    //Función de prueba para obtener un héroe por su ID cuando la API devuelve una lista con un héroe
    @Test
    fun `when the Api return something then get values from Api`() = runBlocking {
        //Given
        val hero = mockk<Hero>(relaxed = true)
        coEvery { heroRepository.getHeroByIdFromApi(any()) } returns listOf(hero)

        //When
        val response = getHeroByIdUseCase()

        //Then
        coVerify(exactly = 1) { heroRepository.clearHeroDatabase() }
        coVerify(exactly = 1) { heroRepository.insertHerosToDatabase(any()) }
        coVerify(exactly = 0) { heroRepository.getHeroByIdFromDatabase(any()) }
        assert(response == hero)
    }
}
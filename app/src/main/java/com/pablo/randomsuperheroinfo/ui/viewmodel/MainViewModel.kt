package com.pablo.randomsuperheroinfo.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pablo.randomsuperheroinfo.domain.GetHeroByIdUseCase
import com.pablo.randomsuperheroinfo.domain.model.Hero
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

//Clase de estado para la pantalla principal de la aplicación
data class MainUiState(
    val isLoading: Boolean = false,
    val hero: Hero? = null,
    val error: String? = null
)

//ViewModel para la pantalla principal de la aplicación
@HiltViewModel
class MainViewModel @Inject constructor(
    private val getHeroByIdUseCase: GetHeroByIdUseCase //Caso de uso para obtener un héroe por su ID utilizando Dagger Hilt
) : ViewModel() {

    //Estado mutable para la pantalla principal de la aplicación utilizando Flow
    private val _uiState = MutableStateFlow(MainUiState())
    val uiState: StateFlow<MainUiState> = _uiState.asStateFlow()

    //Función para obtener un héroe por su ID al inicializar el ViewModel
    init {
        getRandomHeroById()
    }

    //Función para obtener un héroe por su ID utilizando el caso de uso y actualizar el estado
    fun getRandomHeroById() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }
            try {
                val result = getHeroByIdUseCase()
                Log.d("API_CHECK", "Heroe recibido: $result")
                _uiState.update { 
                    it.copy(
                        isLoading = false,
                        hero = result,
                        error = null
                    )
                }
            } catch (e: Exception) {
                _uiState.update { 
                    it.copy(
                        isLoading = false,
                        error = e.message ?: "Error al obtener el Héroe"
                    )
                }
            }
        }
    }
}

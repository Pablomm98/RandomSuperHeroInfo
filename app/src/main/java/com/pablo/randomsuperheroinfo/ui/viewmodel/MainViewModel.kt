package com.pablo.randomsuperheroinfo.ui.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pablo.randomsuperheroinfo.domain.GetHeroByIdUseCase
import kotlinx.coroutines.launch

//ViewModel para la pantalla principal de la aplicación
class MainViewModel: ViewModel() {

    //LiveData para el estado de carga del héroe
    private val _onHeroLoaded = MutableLiveData<Boolean>()
    val onHeroLoaded: LiveData<Boolean> = _onHeroLoaded

    //LiveData para los datos del héroe obtenido de la API
    private val _id = MutableLiveData<String>()
    val id: LiveData<String> = _id

    private val _name = MutableLiveData<String>()
    val name: LiveData<String> = _name

    private val _fullName = MutableLiveData<String>()
    val fullName: LiveData<String> = _fullName

    private val _intelligence = MutableLiveData<String>()
    val intelligence: LiveData<String> = _intelligence

    private val _strength = MutableLiveData<String>()
    val strength: LiveData<String> = _strength

    private val _speed = MutableLiveData<String>()
    val speed: LiveData<String> = _speed

    private val _durability = MutableLiveData<String>()
    val durability: LiveData<String> = _durability

    private val _power = MutableLiveData<String>()
    val power: LiveData<String> = _power

    private val _combat = MutableLiveData<String>()
    val combat: LiveData<String> = _combat

    //Caso de uso para obtener un héroe por su ID
    var getHeroByIdUseCase = GetHeroByIdUseCase()

    //Función para obtener un héroe por su ID al inicializar el ViewModel
    init {
        getRandomHeroById()
    }

    //Función para obtener un héroe por su ID utilizando el caso de uso y actualizar los LiveData con los datos obtenidos
    //Al estar conectado el viewmodel con la vista, se actualiza la vista con los datos obtenidos de la API
    fun getRandomHeroById() {
        _onHeroLoaded.value = false
        viewModelScope.launch {
            val result = getHeroByIdUseCase()
            if(result != null) {
                Log.d("API_CHECK", "Heroe recibido: $result")
                _onHeroLoaded.value = true
                _id.value = result.id
                _name.value = result.name
                _fullName.value = result.biography.fullName
                _intelligence.value = result.powerstats.intelligence
                _strength.value = result.powerstats.strength
                _speed.value = result.powerstats.speed
                _durability.value = result.powerstats.durability
                _power.value = result.powerstats.power
                _combat.value = result.powerstats.combat
            }
        }
    }
}
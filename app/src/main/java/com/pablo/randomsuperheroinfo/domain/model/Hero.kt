package com.pablo.randomsuperheroinfo.domain.model

import com.pablo.randomsuperheroinfo.data.database.entities.HeroEntity
import com.pablo.randomsuperheroinfo.data.model.HeroModel
import kotlinx.serialization.Serializable

// Clase de dominio para representar un héroe
@Serializable
data class Hero(
    val response: String,
    val id: String,
    val name: String,
    val powerstats: PowerStats,
    val biography: Biography,
    val appearance: Appearance,
    val work: Work,
    val connections: Connections,
    val image: Image
)

// Función para mapear el modelo de datos de la API a la clase de dominio
fun HeroModel.toDomain() = Hero(response, id, name, powerstats.toDomain(), biography.toDomain(), appearance.toDomain(), work.toDomain(), connections.toDomain(), image.toDomain())
// Función para mapear la entidad de la base de datos a la clase de dominio
fun HeroEntity.toDomain() = Hero(response, id, name, powerstats.toDomain(), biography.toDomain(), appearance.toDomain(), work.toDomain(), connections.toDomain(), image.toDomain())

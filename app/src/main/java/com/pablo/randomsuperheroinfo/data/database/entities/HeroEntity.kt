package com.pablo.randomsuperheroinfo.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.pablo.randomsuperheroinfo.domain.model.Hero

// Clase de entidad para representar un héroe en la base de datos
@Entity(tableName = "hero_table")
data class HeroEntity(
    @ColumnInfo(name = "response") val response: String,
    @PrimaryKey @ColumnInfo(name = "id") val id: String,
    @ColumnInfo(name = "name") val name: String,
    @Embedded(prefix = "powerstats_") val powerstats: PowersStatsEntity,
    @Embedded(prefix = "biography_") val biography: BiographyEntity,
    @Embedded(prefix = "appearance_") val appearance: AppearanceEntity,
    @Embedded(prefix = "work_") val work: WorkEntity,
    @Embedded(prefix = "connections_") val connections: ConnectionsEntity,
    @Embedded(prefix = "image_") val image: ImageEntity
)

// Función para mapear de la clase de dominio a la entidad de la base de datos
fun Hero.toDatabase() = HeroEntity(response, id, name, powerstats.toDatabase(), biography.toDatabase(), appearance.toDatabase(), work.toDatabase(), connections.toDatabase(), image.toDatabase())
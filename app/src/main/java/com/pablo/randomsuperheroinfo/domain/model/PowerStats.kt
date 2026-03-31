package com.pablo.randomsuperheroinfo.domain.model

import com.pablo.randomsuperheroinfo.data.database.entities.PowersStatsEntity
import com.pablo.randomsuperheroinfo.data.model.PowersStatsModel
import kotlinx.serialization.Serializable

@Serializable
data class PowerStats(
    val intelligence: String,
    val strength: String,
    val speed: String,
    val durability: String,
    val power: String,
    val combat: String
)
fun PowersStatsModel.toDomain() = PowerStats(intelligence, strength, speed, durability, power, combat)

fun PowersStatsEntity.toDomain() = PowerStats(intelligence, strength, speed, durability, power, combat)
package com.pablo.randomsuperheroinfo.domain.model

import com.pablo.randomsuperheroinfo.data.database.entities.AppearanceEntity
import com.pablo.randomsuperheroinfo.data.model.AppearanceModel
import kotlinx.serialization.Serializable

@Serializable
data class Appearance(
    val gender: String,
    val race: String,
    val height: List<String>,
    val weight: List<String>,
    val eyeColor: String,
    val hairColor: String
)

fun AppearanceModel.toDomain() = Appearance(gender, race, height, weight, eyeColor, hairColor)

fun AppearanceEntity.toDomain() = Appearance(gender, race, height, weight, eyeColor, hairColor)
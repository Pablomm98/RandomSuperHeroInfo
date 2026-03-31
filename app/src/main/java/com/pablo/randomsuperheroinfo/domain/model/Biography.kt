package com.pablo.randomsuperheroinfo.domain.model

import com.pablo.randomsuperheroinfo.data.database.entities.BiographyEntity
import com.pablo.randomsuperheroinfo.data.model.BiographyModel
import kotlinx.serialization.Serializable

@Serializable
data class Biography(
    val fullName: String,
    val alterEgos: String,
    val aliases: List<String>,
    val placeOfBirth: String,
    val firstAppearance: String,
    val publisher: String,
    val alignment: String
)

fun BiographyModel.toDomain() = Biography(fullName, alterEgos, aliases, placeOfBirth, firstAppearance, publisher, alignment)

fun BiographyEntity.toDomain() = Biography(fullName, alterEgos, aliases, placeOfBirth, firstAppearance, publisher, alignment)
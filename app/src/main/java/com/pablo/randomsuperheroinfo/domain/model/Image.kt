package com.pablo.randomsuperheroinfo.domain.model

import com.pablo.randomsuperheroinfo.data.database.entities.ImageEntity
import com.pablo.randomsuperheroinfo.data.model.ImageModel
import kotlinx.serialization.Serializable

@Serializable
data class Image(
    val url: String
)

fun ImageModel.toDomain() = Image(url)

fun ImageEntity.toDomain() = Image(url)
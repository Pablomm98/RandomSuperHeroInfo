package com.pablo.randomsuperheroinfo.domain.model

import com.pablo.randomsuperheroinfo.data.database.entities.WorkEntity
import com.pablo.randomsuperheroinfo.data.model.WorkModel
import kotlinx.serialization.Serializable

@Serializable
data class Work(
    val occupation: String,
    val base: String
)

fun WorkModel.toDomain() = Work(occupation, base)

fun WorkEntity.toDomain() = Work(occupation, base)
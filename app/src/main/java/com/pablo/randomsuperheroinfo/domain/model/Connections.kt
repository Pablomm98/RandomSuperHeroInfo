package com.pablo.randomsuperheroinfo.domain.model

import com.pablo.randomsuperheroinfo.data.database.entities.ConnectionsEntity
import com.pablo.randomsuperheroinfo.data.model.ConnectionsModel
import kotlinx.serialization.Serializable

@Serializable
data class Connections(
    val groupAffiliation: String,
    val relatives: String
)

fun ConnectionsModel.toDomain() = Connections(groupAffiliation, relatives)

fun ConnectionsEntity.toDomain() = Connections(groupAffiliation, relatives)
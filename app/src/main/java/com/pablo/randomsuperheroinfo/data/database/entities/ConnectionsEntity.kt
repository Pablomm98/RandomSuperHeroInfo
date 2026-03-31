package com.pablo.randomsuperheroinfo.data.database.entities

import androidx.room.ColumnInfo
import com.pablo.randomsuperheroinfo.domain.model.Connections

data class ConnectionsEntity(
    @ColumnInfo(name = "group_affiliation") val groupAffiliation: String,
    @ColumnInfo(name = "relatives") val relatives: String
)

fun Connections.toDatabase() = ConnectionsEntity(groupAffiliation, relatives)

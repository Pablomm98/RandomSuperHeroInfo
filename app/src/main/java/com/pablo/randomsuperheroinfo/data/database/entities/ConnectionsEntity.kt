package com.pablo.randomsuperheroinfo.data.database.entities

import androidx.room.ColumnInfo

data class ConnectionsEntity(
    @ColumnInfo(name = "group_affiliation") val groupAffiliation: String,
    @ColumnInfo(name = "relatives") val relatives: String
)

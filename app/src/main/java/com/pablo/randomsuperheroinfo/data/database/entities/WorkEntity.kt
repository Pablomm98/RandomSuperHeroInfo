package com.pablo.randomsuperheroinfo.data.database.entities

import androidx.room.ColumnInfo

data class WorkEntity(
    @ColumnInfo(name = "occupation") val occupation: String,
    @ColumnInfo(name = "base") val base: String
)

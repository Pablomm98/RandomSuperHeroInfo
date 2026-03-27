package com.pablo.randomsuperheroinfo.data.database.entities

import androidx.room.ColumnInfo

data class ImageEntity(
    @ColumnInfo(name = "url") val url: String
)

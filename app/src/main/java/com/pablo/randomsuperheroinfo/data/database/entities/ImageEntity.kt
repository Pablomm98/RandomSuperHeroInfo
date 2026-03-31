package com.pablo.randomsuperheroinfo.data.database.entities

import androidx.room.ColumnInfo
import com.pablo.randomsuperheroinfo.domain.model.Image

data class ImageEntity(
    @ColumnInfo(name = "url") val url: String
)

fun Image.toDatabase() = ImageEntity(url)

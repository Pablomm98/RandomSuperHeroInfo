package com.pablo.randomsuperheroinfo.data.database.entities

import androidx.room.ColumnInfo

data class AppearanceEntity(
    @ColumnInfo(name = "gender") val gender: String,
    @ColumnInfo(name = "race") val race: String,
    @ColumnInfo(name = "height") val height: List<String>,
    @ColumnInfo(name = "weight") val weight: List<String>,
    @ColumnInfo(name = "eye_color") val eyeColor: String,
    @ColumnInfo(name = "hair_color") val hairColor: String
)

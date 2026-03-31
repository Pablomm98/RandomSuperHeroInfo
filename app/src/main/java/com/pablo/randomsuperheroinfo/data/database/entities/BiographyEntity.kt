package com.pablo.randomsuperheroinfo.data.database.entities

import androidx.room.ColumnInfo
import com.pablo.randomsuperheroinfo.domain.model.Biography

data class BiographyEntity(
    @ColumnInfo(name = "full_name") val fullName: String,
    @ColumnInfo(name = "alter_egos") val alterEgos: String,
    @ColumnInfo(name = "aliases") val aliases: List<String>,
    @ColumnInfo(name = "place_of_birth") val placeOfBirth: String,
    @ColumnInfo(name = "first_appearance") val firstAppearance: String,
    @ColumnInfo(name = "publisher") val publisher: String,
    @ColumnInfo(name = "alignment") val alignment: String
)

fun Biography.toDatabase() = BiographyEntity(fullName, alterEgos, aliases, placeOfBirth, firstAppearance, publisher, alignment)

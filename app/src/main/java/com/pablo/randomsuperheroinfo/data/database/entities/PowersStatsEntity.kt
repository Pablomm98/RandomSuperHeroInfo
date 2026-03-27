package com.pablo.randomsuperheroinfo.data.database.entities

import androidx.room.ColumnInfo

data class PowersStatsEntity(
    @ColumnInfo(name = "intelligence") val intelligence: String,
    @ColumnInfo(name = "strength") val strength: String,
    @ColumnInfo(name = "speed") val speed: String,
    @ColumnInfo(name = "durability") val durability: String,
    @ColumnInfo(name = "power") val power: String,
    @ColumnInfo(name = "combat") val combat: String
)

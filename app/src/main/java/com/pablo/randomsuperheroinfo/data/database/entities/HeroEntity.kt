package com.pablo.randomsuperheroinfo.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "hero_table")
data class HeroEntity(
    @PrimaryKey @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "name") val name: String,
    @Embedded(prefix = "powerstats_") val powerstats: PowersStatsEntity,
    @Embedded(prefix = "biography_") val biography: BiographyEntity,
    @Embedded(prefix = "appearance_") val appearance: AppearanceEntity,
    @Embedded(prefix = "work_") val work: WorkEntity,
    @Embedded(prefix = "connections_") val connections: ConnectionsEntity,
    @Embedded(prefix = "image_") val image: ImageEntity
)

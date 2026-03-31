package com.pablo.randomsuperheroinfo.data.database.entities

import androidx.room.ColumnInfo
import com.pablo.randomsuperheroinfo.domain.model.Work

data class WorkEntity(
    @ColumnInfo(name = "occupation") val occupation: String,
    @ColumnInfo(name = "base") val base: String
)

fun Work.toDatabase() = WorkEntity(occupation, base)

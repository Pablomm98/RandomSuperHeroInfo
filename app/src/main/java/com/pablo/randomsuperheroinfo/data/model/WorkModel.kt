package com.pablo.randomsuperheroinfo.data.model

import com.google.gson.annotations.SerializedName

data class WorkModel(
    @SerializedName("occupation") val occupation: String,
    @SerializedName("base") val base: String
)

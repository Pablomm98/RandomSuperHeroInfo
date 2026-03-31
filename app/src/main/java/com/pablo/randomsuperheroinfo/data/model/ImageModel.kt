package com.pablo.randomsuperheroinfo.data.model

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

data class ImageModel(
    @SerializedName("url") val url: String
)

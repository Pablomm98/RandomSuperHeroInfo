package com.pablo.randomsuperheroinfo.data.model

import com.google.gson.annotations.SerializedName

data class ConnectionsModel(
    @SerializedName("group-affiliation") val groupAffiliation: String,
    @SerializedName("relatives") val relatives: String
)

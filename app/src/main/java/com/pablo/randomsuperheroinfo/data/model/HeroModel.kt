package com.pablo.randomsuperheroinfo.data.model

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

//Modelo de datos para el héroe de la API
data class HeroModel(
    @SerializedName("response") val response: String,
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("powerstats") val powerstats: PowersStatsModel,
    @SerializedName("biography") val biography: BiographyModel,
    @SerializedName("appearance") val appearance: AppearanceModel,
    @SerializedName("work") val work: WorkModel,
    @SerializedName("connections") val connections: ConnectionsModel,
    @SerializedName("image") val image: ImageModel
)

package com.pablo.randomsuperheroinfo.ui.view

import androidx.navigation3.runtime.NavKey
import com.pablo.randomsuperheroinfo.domain.model.Hero
import kotlinx.serialization.Serializable

sealed class Routes: NavKey {
    @Serializable
    data object Home: Routes()

    @Serializable
    data class HeroDetail(val hero: Hero): Routes()

    @Serializable
    data object Error: Routes()

}
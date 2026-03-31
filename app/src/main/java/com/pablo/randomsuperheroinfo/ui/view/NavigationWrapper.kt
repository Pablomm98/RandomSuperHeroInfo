package com.pablo.randomsuperheroinfo.ui.view

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.pablo.randomsuperheroinfo.core.ex.back
import com.pablo.randomsuperheroinfo.core.ex.navigateTo
import com.pablo.randomsuperheroinfo.ui.viewmodel.MainViewModel

@Composable
fun Navigation3Wrapper(mainViewModel: MainViewModel) {
    val backStack = rememberNavBackStack(Routes.Home)

    NavDisplay(
        backStack = backStack,
        onBack = { backStack.back() },
        entryProvider = entryProvider {
            entry<Routes.Home> {
                MainScreen(mainViewModel) { hero ->
                    backStack.navigateTo(Routes.HeroDetail(hero))
                }
            }
            entry<Routes.HeroDetail> { key ->
                HeroScreen(key.hero) {
                    backStack.back()
                }
            }
            entry<Routes.Error> {
                Text("Error de navegación")
            }
        }
    )
}
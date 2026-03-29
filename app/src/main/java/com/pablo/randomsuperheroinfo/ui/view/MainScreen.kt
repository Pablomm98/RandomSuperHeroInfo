package com.pablo.randomsuperheroinfo.ui.view

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pablo.randomsuperheroinfo.ui.viewmodel.MainViewModel

// Función principal que conecta con el ViewModel
@Composable
fun MainScreen(viewModel: MainViewModel) {
    val id: String by viewModel.id.observeAsState("")
    val onHeroLoaded: Boolean by viewModel.onHeroLoaded.observeAsState(false)
    val name: String by viewModel.name.observeAsState("")
    val fullName: String by viewModel.fullName.observeAsState("")
    val intelligence: String by viewModel.intelligence.observeAsState("0.0")
    val strength: String by viewModel.strength.observeAsState("0.0")
    val speed: String by viewModel.speed.observeAsState("0.0")
    val durability: String by viewModel.durability.observeAsState("0.0")
    val power: String by viewModel.power.observeAsState("0.0")
    val combat: String by viewModel.combat.observeAsState("0.0")

    MainScreenContent(
        onHeroLoaded = onHeroLoaded,
        name = name,
        fullName = fullName,
        intelligence = intelligence,
        strength = strength,
        speed = speed,
        durability = durability,
        power = power,
        combat = combat,
        onRandomHeroClick = { viewModel.getRandomHeroById() },
        onDetailClick = {
            // Aquí iría la lógica de navegación, por ejemplo:
            // navController.navigate("detail/$id")
        }
    )
}

// Función que contiene la UI (sin estado) para facilitar el Preview y las pruebas
@Composable
fun MainScreenContent(
    onHeroLoaded: Boolean,
    name: String,
    fullName: String,
    intelligence: String,
    strength: String,
    speed: String,
    durability: String,
    power: String,
    combat: String,
    onRandomHeroClick: () -> Unit,
    onDetailClick: () -> Unit
) {
    Box(
        Modifier
            .fillMaxSize()
            .clickable { onRandomHeroClick() }) {
        Column(
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            HeroInfoBox(
                modifier = Modifier,
                onHeroLoaded = onHeroLoaded,
                name = name,
                fullName = fullName,
                intelligence = intelligence,
                strength = strength,
                speed = speed,
                durability = durability,
                power = power,
                combat = combat
            )

            if (onHeroLoaded) {
                Spacer(modifier = Modifier.height(24.dp))
                Button(onClick = onDetailClick) {
                    Text(text = "Ficha Completa")
                }
            }
        }
    }
}

// Función que muestra la información del héroe
@Composable
fun HeroInfoBox(
    modifier: Modifier,
    onHeroLoaded: Boolean,
    name: String,
    fullName: String,
    intelligence: String,
    strength: String,
    speed: String,
    durability: String,
    power: String,
    combat: String
) {
    if (!onHeroLoaded) {
        CircularProgressIndicator(modifier = modifier)
    } else {
        Column(
            modifier = modifier,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            MyText(text = name, color = Color.Black, style = MaterialTheme.typography.headlineLarge)
            Spacer(modifier = Modifier.height(4.dp))
            MyText(
                text = fullName,
                color = Color.DarkGray,
                style = MaterialTheme.typography.bodyLarge
            )
            Spacer(modifier = Modifier.height(20.dp))
            PowerStats(
                modifier = Modifier.fillMaxWidth(0.8f),
                (intelligence.toFloatOrNull() ?: 0f) / 100f,
                (strength.toFloatOrNull() ?: 0f) / 100f,
                (speed.toFloatOrNull() ?: 0f) / 100f,
                (durability.toFloatOrNull() ?: 0f) / 100f,
                (power.toFloatOrNull() ?: 0f) / 100f,
                (combat.toFloatOrNull() ?: 0f) / 100f
            )
        }
    }
}

// Función que muestra el texto con los valores elegidos
@Composable
fun MyText(text: String, color: Color, style: TextStyle) {
    Text(text, color = color, style = style)
}

// Función que muestra las estadísticas del héroe en forma de barras
@Composable
fun PowerStats(
    modifier: Modifier = Modifier,
    intelligence: Float,
    strength: Float,
    speed: Float,
    durability: Float,
    power: Float,
    combat: Float
) {
    Column(modifier = modifier) {
        StatRow("Inteligencia", intelligence, Color(0xff004c8c))
        StatRow("Fuerza", strength, Color(0xFF5ab4ac))
        StatRow("Velocidad", speed, Color(0xFFffc107))
        StatRow("Durabilidad", durability, Color(0xFFfd7e14))
        StatRow("Poder", power, Color(0xFFdc3545))
        StatRow("Combate", combat, Color(0xFF6f42c1))
    }
}

// Función que muestra una fila de estadísticas con su respectiva barra
@Composable
fun StatRow(label: String, progress: Float, color: Color) {
    var currentProgress by remember { mutableFloatStateOf(0f) }

    LaunchedEffect(progress) {
        currentProgress = progress
    }

    val animatedProgress by animateFloatAsState(
        targetValue = currentProgress,
        animationSpec = tween(durationMillis = 1000),
        label = "progressAnimation"
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(bottom = 4.dp)
        )
        LinearProgressIndicator(
            progress = { animatedProgress },
            modifier = Modifier
                .fillMaxWidth()
                .height(12.dp),
            color = color,
            trackColor = color.copy(alpha = 0.2f)
        )
    }
}

// Función de vista previa
@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MaterialTheme {
        Surface {
            MainScreenContent(
                onHeroLoaded = true,
                name = "Batman",
                fullName = "Bruce Wayne",
                intelligence = "100",
                strength = "26",
                speed = "27",
                durability = "50",
                power = "47",
                combat = "100",
                onRandomHeroClick = {},
                onDetailClick = {}
            )
        }
    }
}
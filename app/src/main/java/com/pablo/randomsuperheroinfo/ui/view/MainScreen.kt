package com.pablo.randomsuperheroinfo.ui.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

//Función principal
@Composable
fun HeroInfo() {
    Box(Modifier.fillMaxSize()) {
        InfoBox(modifier = Modifier.align(Alignment.Center))
    }
}

//Función que muestra la información del héroe
@Composable
fun InfoBox(modifier: Modifier) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        MyText(text = "Batman", color = Color.Black, style = MaterialTheme.typography.headlineLarge)
        Spacer(modifier = Modifier.height(4.dp))
        MyText(text = "Bruce Wayne", color = Color.DarkGray, style = MaterialTheme.typography.bodyLarge)
        Spacer(modifier = Modifier.height(20.dp))
        PowerStats(modifier = Modifier.fillMaxWidth(0.8f))
    }
}

//Función que muestra el texto con los valores elegidos
@Composable
fun MyText(text: String, color: Color, style: TextStyle) {
    Text(text, color = color, style = style)
}

//Función que muestra las estadísticas del héroe en forma de barras
@Composable
fun PowerStats(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        StatRow("Inteligencia", 0.9f, Color(0xff004c8c))
        StatRow("Fuerza", 0.7f, Color(0xFF5ab4ac))
        StatRow("Velocidad", 0.6f, Color(0xFFffc107))
        StatRow("Durabilidad", 0.8f, Color(0xFFfd7e14))
        StatRow("Poder", 0.8f, Color(0xFFdc3545))
        StatRow("Combate", 0.8f, Color(0xFF6f42c1))
    }
}

//Función que muestra una fila de estadísticas con su respectiva barra
@Composable
fun StatRow(label: String, progress: Float, color: Color) {
    Column(modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)) {
        Text(
            text = label,
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(bottom = 4.dp)
        )
        LinearProgressIndicator(
            progress = { progress },
            modifier = Modifier
                .fillMaxWidth()
                .height(12.dp),
            color = color,
            trackColor = color.copy(alpha = 0.2f)
        )
    }
}

//Función de vista previa de la pantalla completa
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HeroInfoPreview() = HeroInfo()

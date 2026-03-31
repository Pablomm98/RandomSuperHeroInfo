package com.pablo.randomsuperheroinfo.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.pablo.randomsuperheroinfo.domain.model.Appearance
import com.pablo.randomsuperheroinfo.domain.model.Biography
import com.pablo.randomsuperheroinfo.domain.model.Connections
import com.pablo.randomsuperheroinfo.domain.model.Hero
import com.pablo.randomsuperheroinfo.domain.model.Image
import com.pablo.randomsuperheroinfo.domain.model.PowerStats
import com.pablo.randomsuperheroinfo.domain.model.Work
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBar

// Función que muestra la ficha del héroe
@Composable
fun HeroScreen(hero: Hero, navigateBack: () -> Unit) {
    Scaffold(topBar = {
        HeroTopBar(navigateBack = navigateBack)
    }) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Imagen del Héroe
            AsyncImage(
                model = hero.image.url,
                contentDescription = hero.name,
                modifier = Modifier
                    .size(200.dp)
                    .clip(CircleShape)
                    .background(Color.LightGray),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Nombre y Nombre Real
            Text(
                text = hero.name,
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = hero.biography.fullName,
                style = MaterialTheme.typography.titleMedium,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Estadísticas de Poder (Reutilizando la lógica de MainScreen)
            SectionTitle("Power Stats")
            PowerStatsColumn(
                modifier = Modifier.fillMaxWidth(),
                intelligence = (hero.powerstats.intelligence.toFloatOrNull() ?: 0f) / 100f,
                strength = (hero.powerstats.strength.toFloatOrNull() ?: 0f) / 100f,
                speed = (hero.powerstats.speed.toFloatOrNull() ?: 0f) / 100f,
                durability = (hero.powerstats.durability.toFloatOrNull() ?: 0f) / 100f,
                power = (hero.powerstats.power.toFloatOrNull() ?: 0f) / 100f,
                combat = (hero.powerstats.combat.toFloatOrNull() ?: 0f) / 100f
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Biografía
            SectionTitle("Biography")
            InfoCard {
                InfoRow("Alter Egos", hero.biography.alterEgos)
                InfoRow("Place of Birth", hero.biography.placeOfBirth)
                InfoRow("First Appearance", hero.biography.firstAppearance)
                InfoRow("Publisher", hero.biography.publisher)
                InfoRow("Alignment", hero.biography.alignment)
                InfoRow("Aliases", hero.biography.aliases.joinToString(", "))
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Apariencia
            SectionTitle("Appearance")
            InfoCard {
                InfoRow("Gender", hero.appearance.gender)
                InfoRow("Race", hero.appearance.race)
                InfoRow("Height", hero.appearance.height.joinToString(" / "))
                InfoRow("Weight", hero.appearance.weight.joinToString(" / "))
                InfoRow("Eye Color", hero.appearance.eyeColor)
                InfoRow("Hair Color", hero.appearance.hairColor)
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Trabajo
            SectionTitle("Work")
            InfoCard {
                InfoRow("Occupation", hero.work.occupation)
                InfoRow("Base", hero.work.base)
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Conexiones
            SectionTitle("Connections")
            InfoCard {
                InfoRow("Group Affiliation", hero.connections.groupAffiliation)
                InfoRow("Relatives", hero.connections.relatives)
            }
        }

    }
}

// Función que muestra la barra superior con el botón de retroceso
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HeroTopBar(navigateBack: () -> Unit) {
    TopAppBar(
        title = { Text(text = "Ficha del Héroe") },
        navigationIcon = {
            IconButton(onClick = navigateBack) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Volver"
                )
            }
        }
    )
}

@Composable
fun SectionTitle(title: String) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = 8.dp)) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )
        HorizontalDivider(modifier = Modifier.padding(top = 4.dp))
    }
}

@Composable
fun InfoCard(content: @Composable ColumnScope.() -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(
                alpha = 0.5f
            )
        )
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            content()
        }
    }
}

@Composable
fun InfoRow(label: String, value: String) {
    Row(modifier = Modifier.padding(vertical = 4.dp)) {
        Text(
            text = "$label: ",
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.width(120.dp)
        )
        Text(
            text = value,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HeroScreenPreview() {
    val sampleHero = Hero(
        response = "success",
        id = "70",
        name = "Batman",
        powerstats = PowerStats(
            intelligence = "100",
            strength = "26",
            speed = "27",
            durability = "50",
            power = "47",
            combat = "100"
        ),
        biography = Biography(
            fullName = "Bruce Wayne",
            alterEgos = "No alter egos found.",
            aliases = listOf("Insider", "Matches Malone"),
            placeOfBirth = "Gotham City",
            firstAppearance = "Detective Comics #27",
            publisher = "DC Comics",
            alignment = "good"
        ),
        appearance = Appearance(
            gender = "Male",
            race = "Human",
            height = listOf("6'2", "188 cm"),
            weight = listOf("210 lb", "95 kg"),
            eyeColor = "blue",
            hairColor = "black"
        ),
        work = Work(
            occupation = "Businessman",
            base = "Batcave, Gotham City"
        ),
        connections = Connections(
            groupAffiliation = "Batman Family, Justice League",
            relatives = "Damian Wayne (son), Dick Grayson (adopted son)"
        ),
        image = Image(url = "https://www.superherodb.com/pictures2/portraits/10/050/639.jpg")
    )

    MaterialTheme {
        Surface {
            HeroScreen(hero = sampleHero) {}
        }
    }
}

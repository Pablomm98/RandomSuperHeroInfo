# Random SuperHero Info

App ejemplo programada en Kotlin con Jetpack Compose aplicando Clean Architecture, arquitectura MVVM, librerías como Retrofit 2 para conexión con una API de datos, Navigation 3 para la navegación entre pantallas en la App, Dagger Hilt para la inyección de dependencias, Room para la persistencia de datos en local, corrutinas para tener un flujo de trabajo en distintos hilos, CI/CD con GitHub Actions para integración contínua y test unitarios para testear el código del proyecto.
Es un ejemplo de la base para un desarrollo consistente, escalable y testeable.

## Estructura de las ramas del repositorio
- [Master](https://github.com/Pablomm98/RandomSuperHeroInfo/tree/master) - Rama por defecto que engloba todos los cambios realizados. Está todo el código del proyecto. 
- [Retrofit](https://github.com/Pablomm98/RandomSuperHeroInfo/tree/retrofit) - Versión del proyecto en la que se añade la librería Retrofit 2 para la conexión con la API y creación de la capa de dominio y funcionalidades básicas de la APP.
- [Dagger Hilt](https://github.com/Pablomm98/RandomSuperHeroInfo/tree/daggerHilt) - Versión del proyecto en la que se añade la librería de Dagger Hilt y añadido la inyencción de dependencias en toda la App.
- [CI/CD](https://github.com/Pablomm98/RandomSuperHeroInfo/tree/ci/cd) - Versión del proyecto en la que se añade la integración contínia con GitHub Actions.
- [Room](https://github.com/Pablomm98/RandomSuperHeroInfo/tree/room) - Versión del proyecto en la que se añade la librería de Room para la persistencia de datos en local. Creación y configuración de la base de datos local.
- [Navigation3](https://github.com/Pablomm98/RandomSuperHeroInfo/tree/navigation3) - Versión del proyecto en la que se añade la librería Navigation3 para la navegación entre pantallas de la APP. Además de una nueva pantalla con los datos del héroe.
- [Flows](https://github.com/Pablomm98/RandomSuperHeroInfo/tree/flows) - Versión del proyecto en la que se añade Kotlin Flow para la obtención de datos de la base de datos y representarlos en la vista.
Modificación del viewmodel cambiando los livedata por stateflow.
Adaptación de la vista principal al stateflow
- [UnitTests](https://github.com/Pablomm98/RandomSuperHeroInfo/tree/unitTests) - Versión del proyecto en la que se añade la librería de Mockk para la creación de tests unitarios.

## Capturas de la App
<table style="width: 100%;">
  <tr>
    <td style="width: 33%; text-align: center;">
      <img src="https://i.imgur.com/70SIIG9.jpeg" alt="Captura 1" width="100%">
      <br><em>Pantalla principal Light</em>
    </td>
    <td style="width: 33%; text-align: center;">
      <img src="https://i.imgur.com/IxVHcwt.jpeg" alt="Captura 2" width="100%">
      <br><em>Ficha superheroe Light</em>
    </td>
    <td style="width: 33%; text-align: center;">
      <img src="https://i.imgur.com/8JE7F1p.jpeg" alt="Captura 3" width="100%">
      <br><em>Ficha superheroe Light</em>
    </td>
  </tr>
</table>

<table style="width: 100%;">
  <tr>
    <td style="width: 33%; text-align: center;">
      <img src="https://i.imgur.com/CLXmyFF.jpeg" alt="Captura 1" width="100%">
      <br><em>Pantalla principal Dark</em>
    </td>
    <td style="width: 33%; text-align: center;">
      <img src="https://i.imgur.com/x7DXHZU.jpeg" alt="Captura 2" width="100%">
      <br><em>Ficha superheroe Dark</em>
    </td>
    <td style="width: 33%; text-align: center;">
      <img src="https://i.imgur.com/29gv8Sk.jpeg" alt="Captura 3" width="100%">
      <br><em>Ficha superheroe Dark</em>
    </td>
  </tr>
</table>

## Importante a tener en cuenta para correcto funcionamiento
Es necesario añadir algunas librerías en el archivo libs.versions.toml para la implementación de todas las funcionalidades de la App.
```gradle
androidx-compose-material-icons-extended = { group = "androidx.compose.material", name = "material-icons-extended" }
retrofit = { module = "com.squareup.retrofit2:retrofit", version.ref = "retrofit" }
kotlin-coroutines-core = { group = "org.jetbrains.kotlinx", name = "kotlinx-coroutines-core", version.ref = "kotlinxCoroutines" }
kotlin-coroutines-android = { group = "org.jetbrains.kotlinx", name = "kotlinx-coroutines-android", version.ref = "kotlinxCoroutines" }
androidx-compose-runtime-livedata = { group = "androidx.compose.runtime", name = "runtime-livedata", version.ref = "runtimeLivedata" }
hilt-android = { group = "com.google.dagger", name = "hilt-android", version.ref = "hilt" }
hilt-compiler = { group = "com.google.dagger", name = "hilt-compiler", version.ref = "hilt" }
room-runtime = { group = "androidx.room", name = "room-runtime", version.ref = "room" }
room-compiler = { group = "androidx.room", name = "room-compiler", version.ref = "room" }
room-ktx = { group = "androidx.room", name = "room-ktx", version.ref = "room" }
androidx-navigation3-runtime = { module = "androidx.navigation3:navigation3-runtime", version.ref = "nav3Core" }
androidx-navigation3-ui = { module = "androidx.navigation3:navigation3-ui", version.ref = "nav3Core" }
androidx-lifecycle-viewmodel-navigation3 = { module = "androidx.lifecycle:lifecycle-viewmodel-navigation3", version.ref = "lifecycleViewmodelNav3" }
kotlinx-serialization-core = { module = "org.jetbrains.kotlinx:kotlinx-serialization-core", version.ref = "kotlinxSerializationCore" }
androidx-material3-adaptive-navigation3 = { group = "androidx.compose.material3.adaptive", name = "adaptive-navigation3", version.ref = "material3AdaptiveNav3" }
coil-compose = { group = "io.coil-kt", name = "coil-compose", version.ref = "coil" }
mockk = { group = "io.mockk", name = "mockk", version.ref = "mockk" }
mockk-android = { group = "io.mockk", name = "mockk-android", version.ref = "mockk" }
kotlin-coroutines-test = { group = "org.jetbrains.kotlinx", name = "kotlinx-coroutines-test", version.ref = "kotlinxCoroutines" }
androidx-arch-core-testing = { group = "androidx.arch.core", name = "core-testing", version.ref = "archCoreTesting" }
```
Y sus correspondientes versiones (son las últimas versiones disponibles en el momento de creación de la app)
```gradle
retrofit = "3.0.0"
kotlinxCoroutines = "1.10.2"
runtimeLivedata = "1.10.6"
hilt = "2.51.1"
ksp = "2.1.0-1.0.29"
room = "2.8.4"
nav3Core = "1.0.1"
lifecycleViewmodelNav3 = "2.11.0-alpha03"
kotlinSerialization = "2.3.20"
kotlinxSerializationCore = "1.9.0"
material3AdaptiveNav3 = "1.3.0-alpha09"
coil = "2.7.0"
mockk = "1.14.9"
junitJupiter = "6.0.3"
archCoreTesting = "2.2.0"
```
Además de varios plugins como Hilt, KSP y la serialización de kotlin
```gradle
hilt = { id = "com.google.dagger.hilt.android", version.ref = "hilt" }
ksp = { id = "com.google.devtools.ksp", version.ref = "ksp" }
jetbrains-kotlin-serialization = { id = "org.jetbrains.kotlin.plugin.serialization", version.ref = "kotlinSerialization"}
```
En el gradle del módulo APP es necesario añadir los plugins de hilt, ksp y kotlin.serialization
```gradle
alias(libs.plugins.hilt)
alias(libs.plugins.ksp)
alias(libs.plugins.jetbrains.kotlin.serialization)
```
Y las dependencias correspondientes para todas las librerías y plugins que se han añadido
```gradle
// Dagger Hilt
implementation(libs.hilt.android)
ksp(libs.hilt.compiler)
// Retrofit
implementation(libs.retrofit)
implementation(libs.converter.gson)
// Corrutinas
implementation(libs.kotlin.coroutines.core)
implementation(libs.kotlin.coroutines.android)
testImplementation(libs.kotlin.coroutines.test)
// LiveData
implementation(libs.androidx.compose.runtime.livedata)
// Room
implementation(libs.room.runtime)
implementation(libs.room.ktx)
ksp(libs.room.compiler)
//Navigation3
implementation(libs.androidx.navigation3.ui)
implementation(libs.androidx.navigation3.runtime)
implementation(libs.androidx.lifecycle.viewmodel.navigation3)
implementation(libs.androidx.material3.adaptive.navigation3)
implementation(libs.kotlinx.serialization.core)
//Coil
implementation(libs.coil.compose)
//Icons Extended
implementation(libs.androidx.compose.material.icons.extended)
//Mockk
testImplementation(libs.mockk)
androidTestImplementation(libs.mockk.android)
//JUnit
testImplementation(libs.junit.jupiter)
//Testing
testImplementation(libs.androidx.arch.core.testing)
```

## Autor
- [Pablo Martín](https://www.github.com/Pablomm98)
- [LinkedIn](https://www.linkedin.com/in/pablo-martín-maría)

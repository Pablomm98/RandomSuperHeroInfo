package com.pablo.randomsuperheroinfo

import android.app.Application
import android.util.Log
import coil.ImageLoader
import coil.ImageLoaderFactory
import coil.util.DebugLogger
import dagger.hilt.android.HiltAndroidApp
import okhttp3.OkHttpClient

//Clase de aplicación que utiliza Dagger Hilt para inyectar dependencias en la aplicación
@HiltAndroidApp
class RandomSuperHeroInfoApp: Application(), ImageLoaderFactory {
    //Función que crea el objeto ImageLoader para cargar imágenes con Coil aplicando un header personalizado para evitar errores de CORS
    override fun newImageLoader(): ImageLoader {
        return ImageLoader.Builder(this)
            .okHttpClient {
                OkHttpClient.Builder()
                    .addInterceptor { chain ->
                        val request = chain.request().newBuilder()
                            .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36")
                            .header("Accept", "image/avif,image/webp,image/apng,image/svg+xml,image/*,*/*;q=0.8")
                            .build()

                        val response = chain.proceed(request)
                        // Log para confirmar qué está pasando realmente
                        Log.d("CoilNet", "URL: ${request.url} | Code: ${response.code}")
                        response
                    }
                    .build()
            }
            .crossfade(true)
            .logger(DebugLogger())
            .build()
    }
}
package com.jubayer_ahamad_tayef.data.di // Package for dependency injection setup in the data layer

import android.util.Log
import com.jubayer_ahamad_tayef.data.network.NetworkServiceImplementation
import com.jubayer_ahamad_tayef.domain.network.NetworkService
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.dsl.module

// Define the Koin module for network dependencies
val networkModule = module {
    // Provide a singleton instance of HttpClient with CIO engine and required configurations
    single {
        HttpClient(CIO) {
            install(ContentNegotiation) {
                json(Json {
                    prettyPrint = true // Makes JSON output more readable
                    isLenient = true // Allows non-standard JSON inputs
                    ignoreUnknownKeys = true // Ignores unknown keys in JSON to avoid errors
                })
            }
            install(Logging) {
                level = LogLevel.ALL // Sets logging level to log all HTTP activity
                logger = object : Logger {
                    override fun log(message: String) {
                        Log.d("SUKHIBAZAR_BACKEND", message) // Logs HTTP activity to Logcat }
                    }

                }
            }
        }
    }
    // Provide a singleton instance of NetworkService using NetworkServiceImplementation
    single<NetworkService> {
        NetworkServiceImplementation(get()) // Injects the HttpClient instance
    }
}
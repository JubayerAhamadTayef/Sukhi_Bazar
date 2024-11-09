package com.jubayer_ahamad_tayef.sukhi_bazar // Defines the package for the main application component

import android.app.Application
import com.jubayer_ahamad_tayef.data.di.dataModule
import com.jubayer_ahamad_tayef.domain.di.domainModule
import com.jubayer_ahamad_tayef.sukhi_bazar.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

// Custom Application class for the SukhiBazar application
class SukhiBazar : Application() {
    override fun onCreate() {
        super.onCreate()

        // Start Koin for dependency injection
        startKoin {
            // Provide Android context to Koin
            androidContext(this@SukhiBazar)

            // Load Koin modules for dependency injection
            modules(
                listOf(
                    appModule, // App-level dependencies
                    dataModule, // Data layer dependencies
                    domainModule // Domain layer dependencies
                )
            )
        }
    }
}
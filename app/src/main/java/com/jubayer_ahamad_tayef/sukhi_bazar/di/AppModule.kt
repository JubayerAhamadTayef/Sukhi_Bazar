package com.jubayer_ahamad_tayef.sukhi_bazar.di // Package declaration for dependency injection setup

import org.koin.dsl.module // Importing Koin's module function for creating DI modules

// Define the main Koin module for the application
val appModule = module {
    // Include the ViewModel module within the app module
    // This allows dependencies declared in the ViewModel module to be available throughout the application
    includes(viewModelModule)
}
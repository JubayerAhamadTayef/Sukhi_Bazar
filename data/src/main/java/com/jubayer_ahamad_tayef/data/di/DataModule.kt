package com.jubayer_ahamad_tayef.data.di // Package for dependency injection setup in the data layer

import org.koin.dsl.module // Importing Koin's module function to create DI modules

// Define the Koin module for data layer dependencies
val dataModule = module {
    // Include the network and repository modules within the data module
    // This makes all dependencies declared in these modules available in the data layer
    includes(networkModule, repositoryModule)
}
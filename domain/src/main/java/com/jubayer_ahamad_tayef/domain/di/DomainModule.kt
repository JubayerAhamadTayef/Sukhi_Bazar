package com.jubayer_ahamad_tayef.domain.di // Package for dependency injection setup in the domain layer

import org.koin.dsl.module // Importing Koin's module function for creating DI modules

// Define the Koin module for domain layer dependencies
val domainModule = module {
    // Include the use case module within the domain module
    // This allows dependencies declared in the use case module to be available in the domain layer
    includes(useCaseModule)
}
package com.jubayer_ahamad_tayef.domain.di // Package for dependency injection setup in the domain layer

import com.jubayer_ahamad_tayef.domain.usecase.GetProductUseCase
import org.koin.dsl.module // Importing Koin's module function for creating DI modules

// Define the Koin module for use case dependencies
val useCaseModule = module {
    // Provide a factory for GetProductUseCase
    // 'get()' resolves the required dependencies for GetProductUseCase
    factory { GetProductUseCase(get()) }
}
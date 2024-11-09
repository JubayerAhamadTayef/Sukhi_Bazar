package com.jubayer_ahamad_tayef.data.di // Package for dependency injection setup in the data layer

import com.jubayer_ahamad_tayef.data.repository.ProductRepositoryImplementation
import com.jubayer_ahamad_tayef.domain.repository.ProductRepository
import org.koin.dsl.module

// Define the Koin module for repository dependencies
val repositoryModule = module {
    // Provide a singleton instance of ProductRepository using ProductRepositoryImplementation
    // 'get()' resolves the required dependencies for ProductRepositoryImplementation
    single<ProductRepository> { ProductRepositoryImplementation(get()) }
}
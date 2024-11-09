package com.jubayer_ahamad_tayef.domain.usecase // Package for use cases in the domain layer

import com.jubayer_ahamad_tayef.domain.repository.ProductRepository

// Use case for getting products
class GetProductUseCase(private val repository: ProductRepository) {

    // Executes the use case to fetch products
    // Calls the getProducts method from the ProductRepository
    suspend fun execute(category: String?) = repository.getProducts(category)
}
package com.jubayer_ahamad_tayef.data.repository // Package for the repository layer

import com.jubayer_ahamad_tayef.domain.model.Product
import com.jubayer_ahamad_tayef.domain.network.NetworkService
import com.jubayer_ahamad_tayef.domain.network.ResultWrapper
import com.jubayer_ahamad_tayef.domain.repository.ProductRepository

// Implementation of the ProductRepository interface
class ProductRepositoryImplementation(private val networkService: NetworkService) :
    ProductRepository {

    // Fetches products from the network service
    override suspend fun getProducts(category: String?): ResultWrapper<List<Product>> {
        return networkService.getProducts(category)
    }
}
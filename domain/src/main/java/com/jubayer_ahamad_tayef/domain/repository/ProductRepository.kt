package com.jubayer_ahamad_tayef.domain.repository // Package for repository interfaces in the domain layer

import com.jubayer_ahamad_tayef.domain.model.Product
import com.jubayer_ahamad_tayef.domain.network.ResultWrapper

// Interface for product repository operations
interface ProductRepository {
    // Suspended function to fetch products
    // Returns a ResultWrapper containing a list of products or an error
    suspend fun getProducts(category: String?): ResultWrapper<List<Product>>
}